package com.agri.irrigation.service.plot;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IPlotServiceImpl implements IPlotService {

    private static final Logger LOG = LoggerFactory.getLogger(IPlotServiceImpl.class);

    @Autowired
    @Qualifier("jdbcIrr")
    private JdbcTemplate jdbcIrr;

    @Override
    public Integer addPlot(Plot nP) {
        // Add the new plot.
        LOG.info("Adding the new plot.");
        return jdbcIrr.update(Constant.SQL_ADD_PLOT, nP.getNo(), nP.getHasSensor(), nP.getRetryCount(), nP.getTimeSlot(), nP.getIsIrrigated(), nP.getWaterQty(), nP.getCropType(), nP.getCultivatedArea());
    }

    @Override
    public Integer configPlot(String pN, String pS) {
        //Configuring the plot on sensor field.
        LOG.info("Configure the plot no: {}", pN);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("has_sensor", pS);
        parameters.put("no", pN);

        return jdbcIrr.update(Constant.SQL_CONFIG_PLOT, parameters);
    }

    @Override
    public Integer updatePlot(Plot uP) {
        //Updating the plot.
        LOG.info("Update the plot no: {}", uP.getNo());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("has_sensor", uP.getHasSensor());
        parameters.put("time_slot", uP.getTimeSlot());
        parameters.put("is_irrigated", uP.getIsIrrigated());
        parameters.put("water_quantity", uP.getWaterQty());
        parameters.put("crop_type", uP.getCropType());
        parameters.put("cultivated_area", uP.getCultivatedArea());
        parameters.put("no", uP.getNo());

        return jdbcIrr.update(Constant.SQL_UPDATE_PLOT, parameters);
    }

    @Override
    public List<Plot> getPlots() {
        //Get all plot.
        List<Plot> gP = jdbcIrr.query(
                Constant.SQL_PLOT_LIST, BeanPropertyRowMapper.newInstance(Plot.class));
        LOG.info("Total plot: {}", gP.size());
        return gP.isEmpty() ? new ArrayList<>() : gP;
    }
}
