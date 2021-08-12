package com.ford.creditmanager.tdddemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.creditmanager.tdddemo.domain.Vehicle;
import com.ford.creditmanager.tdddemo.repository.VehicleRepository;
import com.ford.creditmanager.tdddemo.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleControllerImpl.class)
class VehicleControllerImplTest {
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private VehicleServiceImpl vehicleService;

    private Vehicle car;
    private Vehicle updatedCar;

    @BeforeEach
    public void setUp() {
        car = Vehicle.builder().vin(UUID.randomUUID()).model("Escape 2020").build();
        updatedCar = Vehicle.builder().vin(UUID.randomUUID()).model("Machi-ev 2021").build();
    }

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAll() throws Exception {
        Mockito.when(vehicleService.findAll()).thenReturn(List.of(car, updatedCar));
        mockMvc.perform(
                MockMvcRequestBuilders.get("/vehicles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(content().json(objectMapper.writeValueAsString(List.of(car, updatedCar))))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        Mockito.when(vehicleService.findById(car.getVin())).thenReturn(car);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/vehicles/" + car.getVin())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(content().json(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());

    }

    @Test
    void update() throws Exception {
        Mockito.when(vehicleService.update(car.getVin(), car)).thenReturn(updatedCar);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/vehicles/" + car.getVin())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(car))
        ).andExpect(content().json(objectMapper.writeValueAsString(updatedCar)))
                .andExpect(status().isCreated());

    }

    @Test
    void save() throws Exception {
        Mockito.when(vehicleService.save(car)).thenReturn(car);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/vehicles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(car))
        ).andExpect(content().json(objectMapper.writeValueAsString(car)))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/vehicles/" + car.getVin())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}