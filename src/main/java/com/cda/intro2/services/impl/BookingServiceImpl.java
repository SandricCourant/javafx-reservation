package com.cda.intro2.services.impl;

import com.cda.intro2.domain.Booking;
import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.repositories.BookingRepository;
import com.cda.intro2.services.BookingService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, Vehicle v1, Vehicle v2){
        this.bookingRepository = bookingRepository;
        Booking annie = new Booking("Annie", "Versaire", v1, "12/03/2023", "14/03/2023", "annie.versaire@gmail.com", "0606060606");
        Booking vincent = new Booking("Vincent", "Time", v2, "15/04/2023", "16/04/2023", "vincent.time@gmail.com", "0707070707");
        bookingRepository.add(annie);
        bookingRepository.add(vincent);
    }
    @Override
    public Booking addBooking(String firstname, String lastname, Vehicle v1, String start, String end, String email, String phone) {
        Booking annie = new Booking(firstname, lastname, v1, start, end, email, phone);
        return bookingRepository.add(annie);
    }

    @Override
    public Iterable<Booking> getBookings() {
        return bookingRepository.getAll();
    }

    @Override
    public Booking getBooking(int index) {
        return bookingRepository.get(index);
    }

    @Override
    public Booking setBooking(int index, String firstname, String lastname, Vehicle v1, String start, String end, String email, String phone) {
        Booking annie = new Booking(firstname, lastname, v1, start, end, email, phone);
        return bookingRepository.set(index, annie);
    }

    @Override
    public void removeBooking(int index) {
        bookingRepository.remove(index);
    }
}
