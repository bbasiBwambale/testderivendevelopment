package com.ford.creditmanager.tdddemo.controller;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import com.ford.creditmanager.tdddemo.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleControllerImpl implements IVehicleController{
    @Autowired
    private VehicleServiceImpl vehicleService;

    @Override
    @GetMapping("/")
    public ResponseEntity findAll() {
        return new ResponseEntity(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{vin}")
    @Override
    public ResponseEntity findById(@PathVariable UUID vin) {
        return new ResponseEntity(vehicleService.findById(vin), HttpStatus.OK);
    }

    @PutMapping("/{vin}")
    @Override
    public ResponseEntity update(@PathVariable UUID vin, @RequestBody Vehicle vehicle) {
        return new ResponseEntity(vehicleService.update(vin, vehicle), HttpStatus.CREATED);
    }

    @PostMapping("/")
    @Override
    public ResponseEntity save(@RequestBody Vehicle vehicle) {
        return new ResponseEntity(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @DeleteMapping("/{vin}")
    @Override
    public void deleteById(@PathVariable UUID vin) {
        vehicleService.deleteById(vin);
    }
}
