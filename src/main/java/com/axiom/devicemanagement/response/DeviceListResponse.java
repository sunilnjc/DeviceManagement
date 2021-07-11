package com.axiom.devicemanagement.response;

import java.io.Serializable;
import java.util.List;

import com.axiom.devicemanagement.entity.Device;

import lombok.Data;

@Data
public class DeviceListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Device> data;

}
