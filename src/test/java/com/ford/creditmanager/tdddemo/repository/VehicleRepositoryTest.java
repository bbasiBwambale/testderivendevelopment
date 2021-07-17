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

    @Autowired
    public VehicleRepositoryTest(VehicleRepository repo){
        this.vehicleRepository = repo;
    }

    @Test
    void findAll() {
        assertEquals(0, vehicleRepository.findAll().size());
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

}