package com.ford.creditmanager.tdddemo.controller;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class VehicleControllerImpl implements IVehicleController{
    @Override
    public ResponseEntity findAll() {
        return null;
    }

    @Override
    public ResponseEntity findById(UUID vin) {
        return null;
    }

    @Override
    public ResponseEntity update(UUID vin, Vehicle vehicle) {
        return null;
    }

    @Override
    public ResponseEntity save(Vehicle vehicle) {
        return null;
    }

    @Override
    public void deleteById(UUID vin) {

    }
}
