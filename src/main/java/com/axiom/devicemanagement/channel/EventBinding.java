package com.axiom.devicemanagement.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = { DeviceCreationChannel.class })
public class EventBinding {
}
