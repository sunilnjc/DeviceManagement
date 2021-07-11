package com.axiom.devicemanagement.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel
public class Device implements Serializable {

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
