package com.cda.intro2.services;

import com.cda.intro2.domain.Booking;
import com.cda.intro2.domain.Vehicle;
import javafx.collections.ObservableList;

public interface BookingService {
    void addBooking(String firstname, String lastname, Vehicle vehicle, String start, String end, String email, String phone);
    ObservableList<String> getBookings();
    Booking getBooking(int index);
    void setBooking(int index, String firstname, String lastname, Vehicle vehicle, String start, String end, String email, String phone);
    void removeBooking(int index);
}
