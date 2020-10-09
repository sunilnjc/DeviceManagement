package com.axiom.devicemanagement.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.devicemanagement.constants.Constants;
import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.service.DeviceManagementService;
import com.axiom.devicemanagement.vo.SearchQuery;

@RestController
@RequestMapping(Constants.VERSION_1 + Constants.DEVICES)
public class DeviceManagementController {

	Logger logger = LogManager.getLogger(DeviceManagementController.class);
	
	@Autowired
	DeviceManagementService deviceManagementService;

	@GetMapping(value = Constants.SEARCH)
	public ResponseEntity<?> fetchDeviceDetails(@RequestParam(value = "priceEur", required = false) Long priceEur,
			@RequestParam(value = "sim", required = false) String sim,
			@RequestParam(value = "announceDate", required = false) String announceDate) {
		logger.info("Fetching device details based on the search criteria -- priceEur = {}, sim = {}, announceDate = {}", priceEur, sim, announceDate);
		
		List<Device> deviceList = deviceManagementService.fetchDeviceList(new SearchQuery(priceEur, announceDate, sim));
		
		if(CollectionUtils.isEmpty(deviceList))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		logger.info("Data has been Successfully retrieved from the database = {}", deviceList);
		
		return new ResponseEntity<>(deviceList, HttpStatus.OK);

	}

}
