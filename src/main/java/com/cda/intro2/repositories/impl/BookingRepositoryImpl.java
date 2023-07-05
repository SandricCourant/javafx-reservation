package com.cda.intro2.repositories.impl;

import com.cda.intro2.domain.Booking;
import com.cda.intro2.repositories.BookingRepository;

import java.util.ArrayList;

public class BookingRepositoryImpl implements BookingRepository {
    private final ArrayList<Booking> dataList;
    public BookingRepositoryImpl(){
        dataList = new ArrayList<>();
    }
    @Override
    public Booking add(Booking booking) {
        dataList.add(booking);
        return booking;
    }

    @Override
    public ArrayList<Booking> getAll() {
        return dataList;
    }

    @Override
    public Booking get(int index) {
        return dataList.get(index);
    }

    @Override
    public Booking set(int index, Booking booking) {
        dataList.set(index, booking);
        return dataList.get(index);
    }

    @Override
    public void remove(int index) {
        dataList.remove(index);
    }
}
