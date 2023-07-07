package com.cda.intro2.services.impl;

import com.cda.intro2.Container;
import com.cda.intro2.domain.Booking;
import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.services.BookingService;
import com.cda.intro2.services.ObservableStorageService;
import com.cda.intro2.services.VehicleService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ObservableStorageServiceImpl implements ObservableStorageService {
    private final ObservableList<String> observableVehicleList;
    private final ObservableList<String> observableBookingList;
    public ObservableStorageServiceImpl(){
        Container container = Container.getInstance();
        observableVehicleList = FXCollections.observableArrayList();
        observableBookingList = FXCollections.observableArrayList();
        for (Vehicle vehicle:
        container.get(VehicleService.class).getVehicles()) {
            observableVehicleList.add(vehicle.toString());
        }
        for (Booking booking:
        container.get(BookingService.class).getBookings()) {
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
