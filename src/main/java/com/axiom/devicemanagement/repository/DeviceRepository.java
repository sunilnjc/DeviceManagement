package com.axiom.devicemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axiom.devicemanagement.entity.Device;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

}

