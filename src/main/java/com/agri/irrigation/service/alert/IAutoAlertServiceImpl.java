package com.agri.irrigation.service.alert;

import com.agri.irrigation.model.Plot;
import com.agri.irrigation.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IAutoAlertServiceImpl implements IAutoAlertService {

    private static final Logger LOG = LoggerFactory.getLogger(IAutoAlertServiceImpl.class);

    @Autowired
    @Qualifier("jdbcIrr")
    private JdbcTemplate jdbcIrr;

    @Override
    public List<Plot> checkPlotsForAutoAlerting(Integer retryMax) {
        //Call for filtering plots for automatic alerting for non sensor and retry exceed.
        List<Plot> alertP = jdbcIrr.query(
                Constant.SQL_PLOT_AUTO_ALERT, BeanPropertyRowMapper.newInstance(Plot.class));
        LOG.info("Total plot to check for alert: {}", alertP.size());
        List<Plot> aP = alertP.stream().filter(p -> p.getRetryCount() > retryMax).collect(Collectors.toList());
        LOG.info("Alert retry max: {}, plot count: {}", retryMax, aP.size());
        return aP.isEmpty() ? new ArrayList<>() : aP;
    }
}
