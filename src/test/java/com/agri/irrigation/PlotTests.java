
package com.agri.irrigation;

import com.agri.irrigation.model.Plot;
import com.agri.irrigation.service.plot.IPlotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlotTests {

	@Autowired
	private IPlotService plotService;

	@Test
	void addPlotTest() {
		Plot p = new Plot();
		p.setNo("P3");
		p.setHasSensor("N");
		p.setTimeSlot("2022-04-08 14:59");
		p.setIsIrrigated("N");
		p.setWaterQty(5);
		p.setCropType("Cash");
		p.setCultivatedArea(500);
		Integer res = plotService.addPlot(p);
		Assertions.assertEquals(1, res);
	}

	@Test
	void configPlotTest() {
		String plotNo = "P3";
		Integer configuredCount = 1;
		Integer res = plotService.configPlot(plotNo, "Y");
		Assertions.assertEquals(configuredCount, res);
	}

	@Test
	void updatePlotTest() {
		Plot p = new Plot();
		p.setNo("P3");
		p.setCultivatedArea(6);
		Integer res = plotService.updatePlot(p);
		Assertions.assertEquals(1, res);
	}

	@Test
	void getPlotsTest() {
		Integer givenCount = 3;
		List<Plot> res = plotService.getPlots();
		Assertions.assertEquals(givenCount, res.size());
	}
}

