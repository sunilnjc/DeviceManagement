package com.axiom.devicemanagement.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;


@Component
public interface DeviceCreationChannel extends GeneralChannel {

	@Output(ChannelsNames.OUT_DEVICE_REGISTRATION)
	MessageChannel messageChannel();

}
