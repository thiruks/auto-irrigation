package com.agri.irrigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoIrrigationApp {

	public static void main(String[] args) {
		SpringApplication.run(AutoIrrigationApp.class, args);
	}

}
