package com.ford.creditmanager.tdddemo.controller;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IVehicleController {
    ResponseEntity findAll();

    ResponseEntity findById(UUID vin);

    ResponseEntity update(UUID vin, Vehicle vehicle);

    ResponseEntity save(Vehicle vehicle);

    void deleteById(UUID vin);


}
