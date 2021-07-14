package com.ford.creditmanager.tdddemo.repository;

import com.ford.creditmanager.tdddemo.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
