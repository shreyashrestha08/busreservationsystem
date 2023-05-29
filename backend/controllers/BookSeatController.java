package com.blume.busbackend.controller;

import com.blume.busbackend.Beans.BookSeatBean;
import com.blume.busbackend.Beans.SeatBean;
import com.blume.busbackend.models.BookSeat;
import com.blume.busbackend.service.BookSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookseat")
public class BookSeatController {
    @Autowired
    BookSeatService bookSeatService;

    @PostMapping("/add")
    Long create(@RequestBody BookSeat bookSeat) {
        return bookSeatService.create(bookSeat).getBookSeatId();
    }

    @PostMapping("/addall")
    List<Long> createall(@RequestBody List<BookSeat> bookSeats) {
        long bookingids = 0;
        List<Long> bookseatidl = new ArrayList<>();
        for (BookSeat bookseat1 : bookSeats){
            bookingids = bookSeatService.create(bookseat1).getBookSeatId();
        bookseatidl.add(bookingids);}
    return bookseatidl;
    }
    @GetMapping("/all")
    List<BookSeat> getAll() {
        return  bookSeatService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable("id") Long id) {
        bookSeatService.delete(id);
        return "BookSeat deleted " + id;
    }



    @GetMapping("/find/{id}")
    BookSeat findById(@PathVariable("id") Long id) {
        return bookSeatService.find(id);
    }

    @GetMapping("/findbybusno/{busNo}")
    List<BookSeat> findByBusNo(@PathVariable("busNo") String busNo) {
        return bookSeatService.findByBusNo(busNo);
    }
    @PostMapping("/findbybusnodate")
    List<BookSeat> findBybnd(@RequestBody List<BookSeat> bookSeatstatus) {
        List<BookSeat> finalstatus= new ArrayList<>();
        for(BookSeat booseat : bookSeatstatus){
            booseat= bookSeatService.findByBusNoAndseatNoAndDate(booseat.getBusNo(), booseat.getSeatNo(), booseat.getDate());
        if(!booseat.getStatus().equals("Booked") ){
            finalstatus.add(booseat);
        }
        }
        return finalstatus;
    }


    @PostMapping("/seatbooked")
    List<String> seatBooked(@RequestBody BookSeatBean bookSeatBean) {
        List<BookSeat> bookSeatList = bookSeatService
                .findByBusNoAndDate(bookSeatBean.getBusNo() , bookSeatBean.getDate());
        HashSet<String> list = new HashSet<>();
        for(BookSeat bookSeat : bookSeatList) {
            if(!(bookSeat.getStatus().equals("Available")) && !(bookSeatBean.getOriginStopRank() >= bookSeat.getBookedDestRank()
                    || bookSeatBean.getDestStopRank() <= bookSeat.getBookedOriginRank())){
                String bookedSeat = bookSeat.getSeatNo();
                for (int i = 0; i < bookedSeat.length(); i++) {
                    if(bookedSeat.charAt(i) != '#'){
                        if(i == bookedSeat.length() - 1 ){
                            char c = bookedSeat.charAt(i);
                            String s = Character.toString(c);
                            list.add(s);
                            continue;
                        }
                        if( i+1 != bookedSeat.length() && bookedSeat.charAt(i+1) =='#' ){
                            char c = bookedSeat.charAt(i);
                            String s = Character.toString(c);
                            list.add(s);
                        }
                        else{
                            char c = bookedSeat.charAt(i);
                            String s = Character.toString(c);
                            c = bookedSeat.charAt(i+1);
                            s = s + Character.toString(c);
                            list.add(s);
                            i = i + 1;
                        }

                    }
                }
            }
        }
        List<String> list1 = new ArrayList<>(list);
        return list1;
    }

    @PutMapping("/updateseatno/{id}")
    BookSeat updateSeatNo(@RequestBody SeatBean SeatBean , @PathVariable("id") Long id) {
        return bookSeatService.edit(SeatBean.getStatus(),id);
    }

    @GetMapping("/getseatno/{id}")
    String getSeatNo(@PathVariable("id") Long id){
        BookSeat bookSeat = bookSeatService.find(id);
        return bookSeat.getSeatNo();
    }

}
