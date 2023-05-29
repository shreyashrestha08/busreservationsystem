package com.blume.busbackend.controller;

import com.blume.busbackend.Beans.BookingBean;
import com.blume.busbackend.models.Booking;
import org.modelmapper.ModelMapper;
import com.blume.busbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BookingService bookingService;
    @PostMapping("/add")
    Booking create(@RequestBody BookingBean booking) {
        return bookingService.create(booking);
    }
    @PostMapping("/addall")
    List<Booking> createall(@RequestBody List<BookingBean> bookings) {
        return bookingService.createAll(bookings);
    }

    @GetMapping("/all")
    List<Booking> getALl() {
        return bookingService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    String deleteId(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return "Successfully Deleted" + id;
    }
    @GetMapping("/findbookseatid/{id}")
    Long findBookSeatId(@PathVariable("id") Long id) {
        Booking booking = bookingService.find(id);
        return booking.getBookSeatId();
    }

    @GetMapping("/find/{id}")
    BookingBean findId(@PathVariable("id") Long id) {
        Booking booking = bookingService.find(id);
        BookingBean bookingBean = modelMapper.map(booking,BookingBean.class);
        bookingBean.setEmail(booking.getUser().getEmail());
        return bookingBean;
    }

    @GetMapping("/findbyemail/{email}")
    List<BookingBean> findByEmail(@PathVariable("email") String email) {
        List<Booking> bookingList = bookingService.findByEmail(email);
        List<BookingBean> bookingBeanList = bookingList
                .stream()
                .map(booking -> modelMapper.map(booking, BookingBean.class)).toList();
        bookingBeanList.forEach((bookingBean) -> bookingBean.setEmail(email));
        return bookingBeanList;
    }
}
