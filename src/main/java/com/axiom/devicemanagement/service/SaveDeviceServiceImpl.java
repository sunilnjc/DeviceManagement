package com.axiom.devicemanagement.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.event.EventType;
import com.axiom.devicemanagement.request.DeviceRequest;

@Service
public class SaveDeviceServiceImpl implements SaveDeviceService {

	Logger logger = LogManager.getLogger(SaveDeviceServiceImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private EventCustomization customEvents;

	@Override
	public String saveDevice(DeviceRequest request) throws Exception {

		logger.info("Mapping request to entity");

		String id = "";

		Device deviceEntity = mapper.map(request, Device.class);

		try {
			deviceEntity = mongoTemplate.save(deviceEntity);
			customEvents.generateEvent(deviceEntity.get_id(), deviceEntity, EventType.CREATE);
		} catch (Exception e) {
			logger.error("PartyCreationException :: Error = {} occured while creating party with interactionId = {}",
					e.getMessage());
			throw new Exception("Saving device failed");
		}

		if (Objects.nonNull(deviceEntity)) {
			id = deviceEntity.get_id();
		}

		return id;
	}

}
