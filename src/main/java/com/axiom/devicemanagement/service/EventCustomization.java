package com.axiom.devicemanagement.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.event.EventType;
import com.axiom.devicemanagement.event.SaveDeviceEvent;
import com.axiom.devicemanagement.producer.DeviceCreationData;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventCustomization {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	DeviceCreationData deviceCreationdata;

	public void generateEvent(String interactionId, Device entity, EventType type) {

		SaveDeviceEvent eventData = modelMapper.map(entity, SaveDeviceEvent.class);
		eventData.setEventName("Device creation Event");
		log.info("Event is prepared to fire");
		deviceCreationdata.send(eventData, type);
		log.info("Event fired successfully");

	}

}