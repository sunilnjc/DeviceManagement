package com.axiom.devicemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DeviceManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManagmentApplication.class, args);
	}
}
