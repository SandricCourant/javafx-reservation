package com.cda.intro2.services;

import com.cda.intro2.domain.Vehicle;

public interface VehicleService {
    Vehicle getVehicle(int index);
    Iterable<Vehicle> getVehicles();
    Vehicle addVehicle(String name, String license);
    Vehicle modifyVehicle(int index, String name, String license);
    void removeVehicle(int index);
    int getVehicleIndex(Vehicle vehicle);
}
