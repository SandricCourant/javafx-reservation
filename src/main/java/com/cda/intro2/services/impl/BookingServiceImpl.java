package com.cda.intro2.services.impl;

import com.cda.intro2.domain.Booking;
import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.repositories.BookingRepository;
import com.cda.intro2.services.BookingService;
import com.cda.intro2.services.VehicleService;

import static com.cda.intro2.AirfrenseApplication.container;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(){
        this.bookingRepository = container.get(BookingRepository.class);
        Booking annie = new Booking("Annie", "Versaire", container.get(VehicleService.class).getVehicle(0), "12/03/2023", "14/03/2023", "annie.versaire@gmail.com", "0606060606");
        Booking vincent = new Booking("Vincent", "Time", container.get(VehicleService.class).getVehicle(1), "15/04/2023", "16/04/2023", "vincent.time@gmail.com", "0707070707");
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
