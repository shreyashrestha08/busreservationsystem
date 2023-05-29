package com.blume.busbackend.service;

import com.blume.busbackend.Beans.BookingBean;
import com.blume.busbackend.models.Booking;

import java.util.List;

public interface BookingService {
    Booking create(BookingBean booking);
    List<Booking> getAll();
    List<Booking> createAll(List<BookingBean> bookings);
    Booking edit(Booking booking);
    void delete(Long id);
    Booking find(Long id);
    List<Booking> findByEmail(String email);
}
