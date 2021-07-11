package com.axiom.devicemanagement.producer;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageBuilderFactory {

	public <T> MessageBuilder<T> getMessageBuilder(T payload) {
		return MessageBuilder.withPayload(payload);
	}
}
