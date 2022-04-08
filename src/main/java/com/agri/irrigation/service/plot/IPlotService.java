package com.agri.irrigation.service.plot;

import com.agri.irrigation.model.Plot;

import java.util.List;

public interface IPlotService {

    public Integer addPlot(Plot nP);

    public Integer configPlot(String pN, String pS);

    public Integer updatePlot(Plot uP);

    public List<Plot> getPlots();
}
