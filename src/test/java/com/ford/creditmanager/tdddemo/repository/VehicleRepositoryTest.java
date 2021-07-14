package com.ford.creditmanager.tdddemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {
    private VehicleRepository vehicleRepository;

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