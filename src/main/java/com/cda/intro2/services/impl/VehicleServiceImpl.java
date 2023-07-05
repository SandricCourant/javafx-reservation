package com.cda.intro2.services.impl;

import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.repositories.VehicleRepository;
import com.cda.intro2.services.VehiculeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehicleServiceImpl implements VehiculeService {

    private final ObservableList<String> observableList = FXCollections.observableArrayList();
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        for (Vehicle data:
                vehicleRepository.getAll()) {
            observableList.add(data.toString());
        }
    }
    @Override
    public Vehicle getVehicle(int index) {
        return vehicleRepository.get(index);
    }
    @Override
    public ObservableList<String> getVehicles() {
        return observableList;
    }
    @Override
    public void addVehicle(String name, String license) {
        Vehicle newVehicle = new Vehicle(name, license);
        observableList.add(vehicleRepository.add(newVehicle).toString());
    }
    @Override
    public void modifyVehicle(int index, String name, String license){
        Vehicle newVehicle = new Vehicle(name, license);
        observableList.set(index, vehicleRepository.set(index, newVehicle).toString());
    }
    @Override
    public void removeVehicle(int index) {
        vehicleRepository.remove(index);
        observableList.remove(index);
    }
    @Override
    public int getVehiculeIndex(Vehicle vehicle) {
        return vehicleRepository.getIndex(vehicle);
    }
}
