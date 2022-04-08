package com.agri.irrigation.model;

/*
This model holds the details of plot.
 */
public class Plot {

    private Long id;
    private String no;
    private String hasSensor;
    private Integer retryCount;
    private String timeSlot;
    private String isIrrigated;
    private Integer waterQty;
    private String cropType;
    private Integer cultivatedArea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getHasSensor() {
        return hasSensor;
    }

    public void setHasSensor(String hasSensor) {
        this.hasSensor = hasSensor;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getIsIrrigated() {
        return isIrrigated;
    }

    public void setIsIrrigated(String isIrrigated) {
        this.isIrrigated = isIrrigated;
    }

    public Integer getWaterQty() {
        return waterQty;
    }

    public void setWaterQty(Integer waterQty) {
        this.waterQty = waterQty;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public Integer getCultivatedArea() {
        return cultivatedArea;
    }

    public void setCultivatedArea(Integer cultivatedArea) {
        this.cultivatedArea = cultivatedArea;
    }
}
