package com.cda.intro2.services;

import com.cda.intro2.domain.Vehicle;
import javafx.collections.ObservableList;

public interface VehiculeService {
    Vehicle getVehicle(int index);
    ObservableList<String> getVehicles();
    void addVehicle(String name, String license);
    void modifyVehicle(int index, String name, String license);
    void removeVehicle(int index);
    int getVehiculeIndex(Vehicle vehicle);
}
