package com.ford.creditmanager.tdddemo.service;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import com.ford.creditmanager.tdddemo.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {
    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    private Vehicle car;
    private Vehicle updatedCar;

    @BeforeEach
    public void setUp(){
        car = Vehicle.builder().vin(UUID.randomUUID()).model("Escape 2020").build();
        updatedCar = Vehicle.builder().vin(UUID.randomUUID()).model("Machi-ev 2021").build();
    }


    @Test
    void findAll() {
        Mockito.when(vehicleRepository.findAll()).thenReturn(List.of(car, updatedCar));
        assertEquals(2, vehicleService.findAll().size());
    }

    @Test
    void findById() {
        Mockito.when(vehicleRepository.findById(car.getVin())).thenReturn(Optional.of(car));
        assertEquals(car, vehicleService.findById(car.getVin()));
    }

    @Test
    void update() {
        Mockito.when(vehicleRepository.save(car)).thenReturn(updatedCar);
        Vehicle car1 = vehicleService.update(car.getVin(), car);
        assertEquals(car1, updatedCar);
    }

    @Test
    void save() {
        Mockito.when(vehicleRepository.save(car)).thenReturn(car);
        assertEquals(car, vehicleService.save(car));
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(vehicleRepository).deleteById(car.getVin());
        vehicleService.deleteById(car.getVin());
        Mockito.verify(vehicleRepository, Mockito.atLeast(1)).deleteById(car.getVin());
    }
}