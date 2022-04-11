
package com.agri.irrigation;

import com.agri.irrigation.model.Plot;
import com.agri.irrigation.service.alert.IAutoAlertService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AutoAlertTests {

    @Autowired
    private IAutoAlertService autoAlertService;

    @Test
    void checkPlotsForAutoAlertingTest() {
        Integer retryMax = 3;
        Integer givenCount = 2;
        List<Plot> res = autoAlertService.checkPlotsForAutoAlerting(retryMax);
        Assertions.assertEquals(givenCount, res.size());
    }
}