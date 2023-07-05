package com.cda.intro2.repositories;

import com.cda.intro2.domain.Booking;

import java.util.ArrayList;

public interface BookingRepository {
    Booking add(Booking booking);
    ArrayList<Booking> getAll();
    Booking get(int index);

    Booking set(int index, Booking booking);
    void remove(int index);
}
