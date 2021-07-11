package com.axiom.devicemanagement.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCommand {

	private String eventName;
	private EventType eventType;

}
