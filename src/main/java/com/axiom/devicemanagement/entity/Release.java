package com.axiom.devicemanagement.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Release implements Serializable{

	@ApiModelProperty(value = "Announcement Date")
	private String announceDate;
	@ApiModelProperty(value = "Price")
	private Long priceEur;

}
