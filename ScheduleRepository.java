package com.blume.busbackend.repo;

import com.blume.busbackend.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long > {
        public List<Schedule> findByBusBusId(Long busId);
}
