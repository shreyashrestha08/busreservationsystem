package com.blume.busbackend.service;

import com.blume.busbackend.Beans.BookingBean;
import com.blume.busbackend.models.Booking;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.models.User;
import com.blume.busbackend.repo.BookingRepository;
import com.blume.busbackend.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public Booking create(BookingBean booking) {
        User user = userRepository.findByEmail(booking.getEmail());
        Booking booking1 = new Booking();
        BeanUtils.copyProperties(booking,booking1,"userId");
        booking1.setUser(user);
        return bookingRepository.save(booking1);
    }


    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> createAll(List<BookingBean> bookings) {

        int i = 0;
        List<Booking> bookingList = new ArrayList<>();
        Booking booking2 = new Booking();
        for (BookingBean bookingss : bookings) {
            User user = userRepository.findByEmail(bookingss.getEmail());
            BeanUtils.copyProperties(bookingss, booking2, "userId");
            booking2.setUser(user);
            bookingList.add(booking2);
        }

        return bookingRepository.saveAll(bookingList);
    }



    @Override
    public Booking edit(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking find(Long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public List<Booking> findByEmail(String email) {
        return bookingRepository.findByUserEmail(email);
    }
}
