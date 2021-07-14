package com.ford.creditmanager.tdddemo.service;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IVehicleService {
    List<Vehicle> findAll();

    Vehicle findById(UUID vin);

    Vehicle update(UUID vin, Vehicle vehicle);

    Vehicle save(Vehicle vehicle);

    void deleteById(UUID vin);
}
