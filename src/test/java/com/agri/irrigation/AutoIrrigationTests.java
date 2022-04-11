
package com.agri.irrigation;

import com.agri.irrigation.model.Plot;
import com.agri.irrigation.service.irrigation.IAutoIrrigationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AutoIrrigationTests {

	@Autowired
	private IAutoIrrigationService autoIrrigationService;

	@Test
	void checkPlotsForAutoIrrigationTest() {
		String pNo = "P3";
		List<Plot> res = autoIrrigationService.checkPlotsForAutoIrrigation();
		Assertions.assertEquals(pNo, res.get(0).getNo());
	}

	@Test
	void updateIsIrrigatedTest() {
		String plotNo = "P3";
		Integer updatedCount = 1;
		Integer res = autoIrrigationService.updateIsIrrigated(plotNo);
		Assertions.assertEquals(updatedCount, res);
	}

	@Test
	void updateRetryCountTest() {
		Integer givenCount = 2;
		Integer res = autoIrrigationService.updateRetryCount();
		Assertions.assertEquals(givenCount, res);
	}

}

