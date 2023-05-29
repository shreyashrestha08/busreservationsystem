package com.blume.busbackend.repo;

import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {
    public List<Bus> findByRouteRouteId(Long routeId);
    public Bus findByBusName(String busName);


}
