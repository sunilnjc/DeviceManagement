package com.axiom.devicemanagement.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Release {

	@ApiModelProperty(value = "Announcement Date")
	private String announceDate;
	@ApiModelProperty(value = "Price")
	private Long priceEur;

}
