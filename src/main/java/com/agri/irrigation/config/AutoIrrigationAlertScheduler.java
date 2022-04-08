package com.agri.irrigation.config;

import com.agri.irrigation.model.Plot;
import com.agri.irrigation.service.alert.IAutoAlertService;
import com.agri.irrigation.service.irrigation.IAutoIrrigationService;
import com.agri.irrigation.util.Constant;
import com.agri.irrigation.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutoIrrigationAlertScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(AutoIrrigationAlertScheduler.class);

    @Autowired
    private IAutoAlertService autoAlertService;

    @Autowired
    private IAutoIrrigationService autoIrrigationService;

    @Autowired
    private Helper helper;

    @Autowired
    private Properties prop;

    @Scheduled(cron = "${cron.expression}")
    public void checkAutoIrrigationAndAlert() {

        //1. Call for Auto Irrigation.
        LOG.info("Checking plots for Automatic-Irrigation-Started.");
        //1.1. Check the eligible plots
        List<Plot> iP = autoIrrigationService.checkPlotsForAutoIrrigation();
        if (!iP.isEmpty()) { // Generate irrigation csv file to send to sensor interface
            helper.generateFile(iP, prop.getIrrFile(), Constant.FILE_SENSOR);
            //1.2. Change the status to isIrrigated (Y)
            String pIdS = iP.stream().map(p -> String.valueOf(p.getId())).collect(Collectors.joining(Constant.SPLITTER_COMMA));
            Integer uI = autoIrrigationService.updateIsIrrigated(pIdS);
            LOG.info("Total plot to update the isIrrigated: {}", uI);

        }
        //1.3. Update the retry count on non sensor
        Integer uR = autoIrrigationService.updateRetryCount();
        LOG.info("Total plot to update the retryCount: {}", uR);

        LOG.info("Checking plots for Automatic-Irrigation-End.");

        //2. Call for Alerting on non sensor and exceed the retry in plot.
        LOG.info("Checking plots for Automatic-Alerting-Started.");
        List<Plot> aP = autoAlertService.checkPlotsForAutoAlerting(Integer.valueOf(prop.getRetryExceed()));
        if (!aP.isEmpty()) // Generate alert csv file to send as attachment in mail(To be done)
            helper.generateFile(aP, prop.getAlertFile(), Constant.FILE_ALERT);
        LOG.info("Checking plots for Automatic-Alerting-End.");
    }
}
