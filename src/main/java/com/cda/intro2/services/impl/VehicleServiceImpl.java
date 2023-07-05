package com.cda.intro2.services.impl;

import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.repositories.VehicleRepository;
import com.cda.intro2.services.VehiculeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehicleServiceImpl implements VehiculeService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public Vehicle getVehicle(int index) {
        return vehicleRepository.get(index);
    }
    @Override
    public Iterable<Vehicle> getVehicles() {
        return vehicleRepository.getAll();
    }
    @Override
    public Vehicle addVehicle(String name, String license) {
        Vehicle newVehicle = new Vehicle(name, license);
        return  vehicleRepository.add(newVehicle);
    }
    @Override
    public Vehicle modifyVehicle(int index, String name, String license){
        Vehicle newVehicle = new Vehicle(name, license);
        return vehicleRepository.set(index, newVehicle);
    }
    @Override
    public void removeVehicle(int index) {
        vehicleRepository.remove(index);
    }
    @Override
    public int getVehicleIndex(Vehicle vehicle) {
        return vehicleRepository.getIndex(vehicle);
    }
}
