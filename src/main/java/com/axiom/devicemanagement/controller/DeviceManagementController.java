package com.axiom.devicemanagement.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.devicemanagement.constants.Constants;
import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.request.DeviceRequest;
import com.axiom.devicemanagement.response.DeviceListResponse;
import com.axiom.devicemanagement.response.SaveDevice;
import com.axiom.devicemanagement.response.SaveDeviceResponse;
import com.axiom.devicemanagement.service.DeviceManagementService;
import com.axiom.devicemanagement.service.SaveDeviceService;
import com.axiom.devicemanagement.vo.SearchQuery;

import io.swagger.annotations.Api;

/**
 * 
 * @author Sunil
 *
 */
@Api(tags = { "devices" })
@RestController
@RequestMapping(Constants.VERSION_1 + Constants.DEVICES)
public class DeviceManagementController {

	Logger logger = LogManager.getLogger(DeviceManagementController.class);

	@Autowired
	DeviceManagementService deviceManagementService;

	@Autowired
	SaveDeviceService saveDeviceService;

//	@Autowired
//	private AuthenticationManager authenticationManager;

//	@Autowired
//	private JwtUtil jwtTokenUtil;
//
//	@Autowired
//	private AuthenticateUserDetailsService userDetailsService;

//	@PostMapping(value = "/authenticate")
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
//			throws Exception {
//
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect username or password", e);
//		}
//
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//	}

	@GetMapping(value = Constants.SEARCH)
	public ResponseEntity<?> fetchDeviceDetails(@RequestParam(value = "priceEur", required = false) Long priceEur,
			@RequestParam(value = "sim", required = false) String sim,
			@RequestParam(value = "announceDate", required = false) String announceDate) {
//		logger.info(
//				"Fetching device details based on the search criteria -- priceEur = {}, sim = {}, announceDate = {}",
//				priceEur, sim, announceDate);

		List<Device> deviceList = deviceManagementService.fetchDeviceList(new SearchQuery(priceEur, announceDate, sim));

		if (CollectionUtils.isEmpty(deviceList))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

//		logger.info("Data has been Successfully retrieved from the database = {}", deviceList);

		DeviceListResponse response = new DeviceListResponse();
		response.setData(deviceList);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * Save Device
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = Constants.SAVE)
	public ResponseEntity<?> save(@RequestBody DeviceRequest request) throws Exception {
		String id = saveDeviceService.saveDevice(request);

		SaveDevice device = new SaveDevice();
		device.setId(id);

		SaveDeviceResponse response = new SaveDeviceResponse();
		response.setData(device);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
