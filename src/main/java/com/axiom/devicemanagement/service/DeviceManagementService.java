package com.axiom.devicemanagement.service;

import java.util.List;

import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.vo.SearchQuery;

public interface DeviceManagementService {

	public List<Device> fetchDeviceList(SearchQuery searchQuery);
}
