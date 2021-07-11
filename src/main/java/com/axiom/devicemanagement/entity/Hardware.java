package com.axiom.devicemanagement.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hardware implements Serializable{

	@ApiModelProperty(value = "Audio Jack")
	private String audioJack;
	@ApiModelProperty(value = "GPS")
	private String gps;
	@ApiModelProperty(value = "battery")
	private String battery;
	
}
