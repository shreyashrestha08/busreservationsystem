package com.blume.busbackend.service;

import com.blume.busbackend.models.BookSeat;

import java.util.List;

public interface BookSeatService {
    BookSeat create(BookSeat bookSeat);
    List<BookSeat> createall(List<BookSeat> bookSeats);
    List<BookSeat> getAll();
    BookSeat edit(String status , Long bookSeatId);
    void delete(Long id);
    BookSeat find(Long id);
    List<BookSeat> findByBusNoAndDate(String busNo , String date);
    List<BookSeat> findByBusNo(String busNo);

    BookSeat findByBusNoAndseatNoAndDate(String busNo, String seatNo, String date);
}
