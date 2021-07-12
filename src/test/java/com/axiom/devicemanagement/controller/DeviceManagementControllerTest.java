package com.axiom.devicemanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.axiom.devicemanagement.service.DeviceManagementService;
import com.axiom.devicemanagement.service.SaveDeviceService;
import com.axiom.devicemanagement.vo.SearchQuery;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest
public class DeviceManagementControllerTest {

	@InjectMocks
	DeviceManagementController deviceControllerTest;

	@MockBean
	DeviceManagementService deviceManagementService;

	@MockBean
	SaveDeviceService saveDeviceService;

	@Autowired
	MockMvc mvc;

	protected void setUp() {

//		SearchQuery query = new SearchQuery(1L, "", "eSim");

		Mockito.when(deviceManagementService.fetchDeviceList(Mockito.any(SearchQuery.class))).thenReturn(null);

	}

	@Test
	public void retrieveDevices() throws Exception {

		// when
		MockHttpServletResponse response = mvc
				.perform(get("/v1/devices/search", mvc.getDispatcherServlet().getServletContext(), "/products"))
				.andReturn().getResponse();

		int status = response.getStatus();
		assertEquals(204, status);

	}
	
	@Test
	public void retrieveDevicesWithParams() throws Exception {
		
		String priceEur = "";
		String sim = "";
		String announceDate = "";
		
		
		// when
		MockHttpServletResponse response = mvc
				.perform(get("/v1/devices/search", mvc.getDispatcherServlet().getServletContext(), "/products")
						 	.param("priceEur", priceEur)
				            .param("sim", sim) 
				            .param("announceDate", announceDate))
				.andReturn().getResponse();
		
		int status = response.getStatus();
		assertEquals(204, status);
		
	}

}
