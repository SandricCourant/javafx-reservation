package com.cda.intro2.repositories.impl;

import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.repositories.VehicleRepository;

import java.util.ArrayList;

public class VehicleRepositoryImpl implements VehicleRepository {
    private final ArrayList<Vehicle> dataList;
    public VehicleRepositoryImpl(){
        dataList = new ArrayList<>();
        //Creer les categories par default
        Vehicle camry = new Vehicle("Toyota Camry", "AB1234");
        Vehicle civic = new Vehicle("Honda Civic", "CD5678");
        Vehicle mustang = new Vehicle("Ford Mustang", "EF9012");
        Vehicle malibu = new Vehicle("Chevrolet Malibu", "GH3456");
        Vehicle golf = new Vehicle("Volkswagen Golf", "IJ7890");
        //Ajouter à datalist
        dataList.add(camry);
        dataList.add(civic);
        dataList.add(mustang);
        dataList.add(malibu);
        dataList.add(golf);
    }
    @Override
    public Vehicle get(int index) {
        return dataList.get(index);
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        return dataList;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        dataList.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle set(int index, Vehicle vehicle) {
        dataList.set(index, vehicle);
        return dataList.get(index);
    }

    @Override
    public void remove(int index) {
        dataList.remove(index);
    }

    @Override
    public int getIndex(Vehicle vehicle) {
        return dataList.indexOf(vehicle);
    }
}
