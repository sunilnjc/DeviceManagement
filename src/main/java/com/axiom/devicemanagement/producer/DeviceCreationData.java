package com.axiom.devicemanagement.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.stereotype.Component;

import com.axiom.devicemanagement.channel.DeviceCreationChannel;
import com.axiom.devicemanagement.event.EventType;
import com.axiom.devicemanagement.event.SaveDeviceEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DeviceCreationData {

	private final DeviceCreationChannel deviceCreationChannel;

	@Autowired
	private KafkaPublisher kafkaPublisher;

	public DeviceCreationData(DeviceCreationChannel deviceCreationChannel) {
		this.deviceCreationChannel = deviceCreationChannel;
	}

	public void send(SaveDeviceEvent event, EventType type) {
		log.info("sending kafka event to create device");
		try {
			event.setEventType(type);
			kafkaPublisher.send(deviceCreationChannel, event);
		} catch (KafkaException e) {
			log.error("encountered exception while sending message to kafka topic");
			throw new KafkaException(e.getMessage());
		}
	}
}
