package com.agri.irrigation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:./application.properties")
public class Properties {

    @Value("${crop.types}")
    private String cropTypes;

    @Value("${irrigation.file}")
    private String irrFile;

    @Value("${retry.exceed}")
    private String retryExceed;

    @Value("${alert.file}")
    private String alertFile;

    public String getCropTypes() {
        return cropTypes;
    }

    public String getIrrFile() {
        return irrFile;
    }

    public String getRetryExceed() {
        return retryExceed;
    }

    public String getAlertFile() {
        return alertFile;
    }
}
