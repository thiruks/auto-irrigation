package com.agri.irrigation.service.irrigation;

import com.agri.irrigation.model.Plot;

import java.util.List;

public interface IAutoIrrigationService {
    public List<Plot> checkPlotsForAutoIrrigation();

    public Integer updateIsIrrigated(String idS);

    public Integer updateRetryCount();
}
