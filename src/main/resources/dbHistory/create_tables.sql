--1.Create the sequence: plot_seq
CREATE SEQUENCE plot_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 1000000
NOCACHE
NOCYCLE;

--2.Create the table: plot
CREATE TABLE plot(
id				        NUMBER PRIMARY KEY,
no  		 		    VARCHAR2(10 CHAR) 	NOT NULL,
has_sensor              VARCHAR2(1 CHAR)	DEFAULT 'N',
sensor_retry_count      NUMBER(1),
time_slot		        DATE,
is_irrigated	        VARCHAR2(1 CHAR)	DEFAULT 'N',
water_quantity	        NUMBER(10),
crop_type		        VARCHAR2(20 CHAR),
cultivated_area	        NUMBER(10)
);

--3.Create the comment on table and column
COMMENT ON TABLE plot IS 'This table holds all plots detail';
COMMENT ON COLUMN plot.id IS 'It is auto generated using sequence: plots_seq';
COMMENT ON COLUMN plot.no IS 'Holds the plot number';
COMMENT ON COLUMN plot.has_sensor IS 'Holds the sensor detail as Y for yes or N for No';
COMMENT ON COLUMN plot.sensor_retry_count IS 'Holds the retry calls count.';
COMMENT ON COLUMN plot.time_slot IS 'Holds the time slot for automatic irrigation';
COMMENT ON COLUMN plot.is_irrigated IS 'Holds the irrigated status as Y for yes or N for No';
COMMENT ON COLUMN plot.water_quantity IS 'Holds the amount of water for irrigation';
COMMENT ON COLUMN plot.crop_type IS 'Holds the crop types(food,cash,drug)';
COMMENT ON COLUMN plot.cultivated_area IS 'Holds the cultivated area';