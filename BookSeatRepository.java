package com.blume.busbackend.repo;

import com.blume.busbackend.models.BookSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSeatRepository extends JpaRepository<BookSeat , Long> {

    List<BookSeat> findByBusNoAndDate(String busNo , String date);
    List<BookSeat> findByBusNo(String busNo);

    BookSeat findByBusNoAndSeatNoAndDate(String busNo, String seatNo, String Date);
}
