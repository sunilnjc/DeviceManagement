package com.axiom.devicemanagement.service;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.axiom.devicemanagement.controller.DeviceManagementController;
import com.axiom.devicemanagement.entity.Device;
import com.axiom.devicemanagement.exception.ResourceNotFoundException;
import com.axiom.devicemanagement.vo.SearchQuery;

/**
 * 
 * @author Sunil
 *
 */

@Service
public class DeviceManagementServiceImpl implements DeviceManagementService {

	Logger logger = LogManager.getLogger(DeviceManagementController.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	@Cacheable(value = "devices")
	public List<Device> fetchDeviceList(SearchQuery searchQuery) {

		Criteria criteria = null;

		logger.info("Creating a criteria based on the query parameters");

		if (!StringUtils.isEmpty(searchQuery.getSim())) {
			criteria = new Criteria();
			criteria = Criteria.where("sim").regex(searchQuery.getSim(), "i");
		}
		if (!StringUtils.isEmpty(searchQuery.getAnnounceDate())) {
			if (Objects.isNull(criteria)) {
				criteria = new Criteria();
				criteria = Criteria.where("release.announceDate").is(searchQuery.getAnnounceDate());
			} else {
				criteria.andOperator(Criteria.where("release.announceDate").is(searchQuery.getAnnounceDate()));
			}
		}
		if (!Objects.isNull(searchQuery.getPriceEur())) {
			if (Objects.isNull(criteria)) {
				criteria = new Criteria();
				criteria = Criteria.where("release.priceEur").is(searchQuery.getPriceEur());
			} else {
				criteria.andOperator(Criteria.where("release.priceEur").is(searchQuery.getPriceEur()));
			}
		}

		Query query = new Query();
		query.addCriteria(criteria);

		logger.info("Query Criteria formed = {}", query);

		List<Device> result = mongoTemplate.find(query, Device.class, "device");
		
		if(CollectionUtils.isEmpty(result)) {
			logger.error("No resources found for the request");
			throw new ResourceNotFoundException("Resource not found for the request");
		}

		return result;
	}

}
