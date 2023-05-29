package com.blume.busbackend.repo;

import com.blume.busbackend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

     public List<Booking> findByUserEmail(String email);
}
