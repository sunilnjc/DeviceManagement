package com.axiom.devicemanagement.event;

import org.springframework.data.annotation.Id;

import com.axiom.devicemanagement.entity.Hardware;
import com.axiom.devicemanagement.entity.Release;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Event model for device creation data", description = "Event model for device data")
public class SaveDeviceEvent extends EventCommand {

	@Id
	@ApiModelProperty(value = "Unique Device ID")
	private String _id;

	@ApiModelProperty(value = "Unique Device ID")
	private Long id;

	@ApiModelProperty(value = "Brand Name")
	private String brand;

	@ApiModelProperty(value = "Phone Name")
	private String phone;

	@ApiModelProperty(value = "Picture")
	private String picture;

	@ApiModelProperty(value = "Release")
	private Release release;

	@ApiModelProperty(value = "SIM")
	private String sim;

	@ApiModelProperty(value = "Resolution")
	private String resolution;

	@ApiModelProperty(value = "Hardware")
	private Hardware hardware;

}
