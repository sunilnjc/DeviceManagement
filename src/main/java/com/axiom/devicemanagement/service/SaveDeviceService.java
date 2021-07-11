package com.axiom.devicemanagement.service;

import com.axiom.devicemanagement.request.DeviceRequest;

public interface SaveDeviceService {

	public default String saveDevice(DeviceRequest request) throws Exception {
		return null;
	}
}
