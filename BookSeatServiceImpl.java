package com.blume.busbackend.service;

import com.blume.busbackend.models.BookSeat;
import com.blume.busbackend.repo.BookSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookSeatServiceImpl implements BookSeatService{

    @Autowired
    BookSeatRepository bookSeatRepository;
    @Override
    public BookSeat create(BookSeat bookSeat) {

        return
                bookSeatRepository.save(bookSeat);
    }

    @Override
    public List<BookSeat> createall(List<BookSeat> bookSeats) {
        return bookSeatRepository.saveAll(bookSeats);
    }

    @Override
    public List<BookSeat> getAll() {
        return bookSeatRepository.findAll();
    }

    @Override
    public BookSeat edit(String status , Long bookSeatId) {
        BookSeat bookSeat = bookSeatRepository.findById(bookSeatId).get();
        bookSeat.setStatus("Booked");
        return bookSeatRepository.save(bookSeat);
    }

    @Override
    public void delete(Long id) {
            bookSeatRepository.deleteById(id);
    }

    @Override
    public BookSeat find(Long id) {
        return bookSeatRepository.findById(id).get();
    }

    @Override
    public List<BookSeat> findByBusNoAndDate(String busNo , String date) {
        return bookSeatRepository.findByBusNoAndDate(busNo , date);
    }

    @Override
    public List<BookSeat> findByBusNo(String busNo) {
        return bookSeatRepository.findByBusNo(busNo);
    }

    @Override
    public BookSeat findByBusNoAndseatNoAndDate(String busNo, String seatNo, String date) {
        return bookSeatRepository.findByBusNoAndSeatNoAndDate(busNo, seatNo, date);

    }

}
