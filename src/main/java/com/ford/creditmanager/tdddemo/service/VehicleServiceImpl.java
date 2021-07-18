package com.ford.creditmanager.tdddemo.service;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import com.ford.creditmanager.tdddemo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(UUID vin) {
        return vehicleRepository.findById(vin).get();
    }

    @Override
    public Vehicle update(UUID vin, Vehicle vehicle) {
        vehicle.setVin(vin);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(UUID vin) {
        vehicleRepository.deleteById(vin);
    }
}
