package com.cda.intro2.repositories;

import com.cda.intro2.domain.Vehicle;

import java.util.ArrayList;

public interface VehicleRepository {
    Vehicle get(int index);
    ArrayList<Vehicle> getAll();
    Vehicle add(Vehicle vehicle);
    Vehicle set(int index, Vehicle vehicle);
    void remove(int index);
    int getIndex(Vehicle vehicle);
}
