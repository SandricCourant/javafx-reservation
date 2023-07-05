package com.cda.intro2.services.impl;

import com.cda.intro2.domain.Booking;
import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.services.ObservableStorageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.cda.intro2.AirfrenseApplication.bookingService;
import static com.cda.intro2.AirfrenseApplication.vehicleService;

public class ObservableStorageServiceImpl implements ObservableStorageService {
    private final ObservableList<String> observableVehicleList;
    private final ObservableList<String> observableBookingList;
    public ObservableStorageServiceImpl(){
        observableVehicleList = FXCollections.observableArrayList();
        observableBookingList = FXCollections.observableArrayList();
        for (Vehicle vehicle:
        vehicleService.getVehicles()) {
            observableVehicleList.add(vehicle.toString());
        }
        for (Booking booking:
        bookingService.getBookings()) {
            observableBookingList.add(booking.toString());
        }
    }
    @Override
    public ObservableList<String> getList(String name) {
        if(name.equals("vehicle")) return observableVehicleList;
        if(name.equals("booking")) return observableBookingList;
        return null;
    }

    @Override
    public void add(String name, String value) {
        if (name.equals("vehicle")) observableVehicleList.add(value);
        if (name.equals("booking")) observableBookingList.add(value);
    }

    @Override
    public void set(String name, int index, String newValue) {
        if (name.equals("vehicle")) observableVehicleList.set(index, newValue);
        if (name.equals("booking")) observableBookingList.set(index, newValue);
    }

    @Override
    public void remove(String name, int index) {
        if (name.equals("vehicle")) observableVehicleList.remove(index);
        if (name.equals("booking")) observableBookingList.remove(index);
    }
}
