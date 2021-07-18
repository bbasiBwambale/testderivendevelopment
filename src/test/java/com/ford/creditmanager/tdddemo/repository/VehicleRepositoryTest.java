package com.ford.creditmanager.tdddemo.repository;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    private Vehicle car;
    private Vehicle updatedCar;

    @BeforeEach
    public void setUp(){
        car = Vehicle.builder().vin(UUID.randomUUID()).model("Escape 2020").build();
        updatedCar = Vehicle.builder().vin(UUID.randomUUID()).model("Machi-ev 2021").build();
    }

    @Test
    void findAll() {
        assertEquals(0, vehicleRepository.findAll().size());
    }

    @Test
    void findById() {
        vehicleRepository.save(car);
        assertEquals(car, vehicleRepository.findById(car.getVin()).get());
    }

    @Test
    void update() {
      Vehicle car1 =   vehicleRepository.save(car);
      car1.setModel(updatedCar.getModel());
        assertEquals(car1.getModel(), vehicleRepository.save(updatedCar).getModel());
    }

    @Test
    void save() {
        assertEquals(car, vehicleRepository.save(car));
    }

    @Test
    void deleteById() {
        vehicleRepository.save(car);
        assertEquals(1, vehicleRepository.findAll().size());
        vehicleRepository.deleteById(car.getVin());
        assertEquals(0, vehicleRepository.findAll().size());
    }

}