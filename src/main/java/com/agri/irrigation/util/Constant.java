package com.agri.irrigation.util;

public class Constant {

    private Constant() {
    }

    public static final String SPLITTER_COMMA = ",";
    public static final String NEW_LINE = "\n";

    public static final String SQL_ADD_PLOT = "INSERT INTO plot VALUES(plot_seq.NEXTVAL, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI'), ?, ?, ?, ?)";
    public static final String SQL_CONFIG_PLOT = "UPDATE plot SET has_sensor = ? WHERE no = ?";
    public static final String SQL_UPDATE_PLOT = "UPDATE plot SET has_sensor = ?, time_slot=TO_DATE(?, 'YYYY-MM-DD HH24:MI'), is_irrigated=?, water_quantity=?, crop_type=?, cultivated_area=? \n" +
            " WHERE no = ?";
    public static final String SQL_PLOT_SELECT = "SELECT id, no, has_sensor AS hasSensor, sensor_retry_count AS retryCount, \n" +
            " TO_CHAR(time_slot, 'YYYY-MM-DD HH24:MI') AS timeSlot, is_irrigated AS isIrrigated, water_quantity AS waterQty, \n" +
            " crop_type AS cropType, cultivated_area AS cultivatedArea ";
    public static final String SQL_PLOT_LIST = SQL_PLOT_SELECT + " FROM plot";
    public static final String SQL_PLOT_AUTO_IRRIGATION = SQL_PLOT_SELECT + " FROM plot WHERE has_sensor = 'Y' AND is_irrigated = 'N' \n ";
    public static final String SQL_IS_IRRIGATED = "UPDATE plot SET \n" +
            " is_irrigated='Y' \n" +
            " where id IN (?) ";
    public static final String SQL_RETRY_COUNT = "UPDATE plot SET \n" +
            " sensor_retry_count=sensor_retry_count+1 \n" +
            " where has_sensor = 'N' AND is_irrigated='N' ";
    public static final String SQL_PLOT_AUTO_ALERT = SQL_PLOT_SELECT + " FROM plot WHERE has_sensor = 'N' AND sensor_retry_count > 1";
    public static final String FILE_HEADER = "ID,PlotNumber,HasSensor,RetryCount,TimeSlot,IsIrrigated,WaterQuantity,CropType,CultivatedArea \n";
    public static final String WATER_QTY = " Litre";
    public static final String PLOT_AREA = " Sq.feet";
    public static final String FILE_SENSOR = "Sensor";
    public static final String FILE_ALERT = "Alert";
}
