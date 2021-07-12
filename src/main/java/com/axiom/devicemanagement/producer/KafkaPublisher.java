package com.axiom.devicemanagement.producer;

import org.apache.kafka.common.KafkaException;
import org.springframework.stereotype.Component;

import com.axiom.devicemanagement.channel.GeneralChannel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaPublisher {
	/**
	 * @param channel
	 * @param event
	 * @param <T>
	 */

	private final MessageBuilderFactory messageBuilderFactory;

	public KafkaPublisher(MessageBuilderFactory messageBuilderFactory) {
		this.messageBuilderFactory = messageBuilderFactory;
	}

	public <T> void send(GeneralChannel channel, T event) {
		log.info("Publishing {}...", event.getClass().getSimpleName());
		log.debug("With event details: {}", event);

		String typeName = event.getClass().getSimpleName();
		if (channel.messageChannel()
				.send(messageBuilderFactory.getMessageBuilder(event).setHeader("type", typeName).build()))
			log.info("Publishing {} event has been published to kafka successfully", event.getClass().getSimpleName());
		else
			throw new KafkaException(
					"Error while sending ".concat(event.getClass().getSimpleName()).concat(" event to kafka."));
	}
}
