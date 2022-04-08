package com.agri.irrigation.service.alert;

import com.agri.irrigation.model.Plot;

import java.util.List;

public interface IAutoAlertService {
    public List<Plot> checkPlotsForAutoAlerting(Integer retryMax);
}
