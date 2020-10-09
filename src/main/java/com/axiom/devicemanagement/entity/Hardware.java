package com.axiom.devicemanagement.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hardware {

	@ApiModelProperty(value = "Audio Jack")
	private String audioJack;
	@ApiModelProperty(value = "GPS")
	private String gps;
	@ApiModelProperty(value = "battery")
	private String battery;
	
}
