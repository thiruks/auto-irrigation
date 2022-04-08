package com.agri.irrigation.service.irrigation;

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

@Service
public class IAutoIrrigationServiceImpl implements IAutoIrrigationService {

    private static final Logger LOG = LoggerFactory.getLogger(IAutoIrrigationServiceImpl.class);

    @Autowired
    @Qualifier("jdbcIrr")
    private JdbcTemplate jdbcIrr;

    @Override
    public List<Plot> checkPlotsForAutoIrrigation() {
        //Call for automatic irrigation on non irrigated plot.
        List<Plot> iP = jdbcIrr.query(
                Constant.SQL_PLOT_AUTO_IRRIGATION, BeanPropertyRowMapper.newInstance(Plot.class));
        LOG.info("Total plot for auto irrigation: {}", iP.size());
        return iP.isEmpty() ? new ArrayList<>() : iP;
    }

    @Override
    public Integer updateIsIrrigated(String idS) {
        LOG.info("Update IsIrrigated IDs: {}", idS);
        return jdbcIrr.update(Constant.SQL_IS_IRRIGATED, idS);
    }

    @Override
    public Integer updateRetryCount() {
        LOG.info("Update Retry count.");
        return jdbcIrr.update(Constant.SQL_RETRY_COUNT);
    }
}
