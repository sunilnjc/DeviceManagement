package com.axiom.devicemanagement.service;

import java.util.List;

import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.request.DeviceRequest;
import com.axiom.devicemanagement.vo.SearchQuery;

public interface DeviceManagementService {

	public default List<Device> fetchDeviceList(SearchQuery searchQuery){
		return null;
		
	}

	public default String saveDevice(DeviceRequest request) throws Exception {
		return null;
	}
}
