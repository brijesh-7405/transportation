package com.transportation.service;

import com.transportation.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
