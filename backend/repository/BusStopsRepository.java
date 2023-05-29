package com.blume.busbackend.repo;

import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.BusStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopsRepository extends JpaRepository<BusStops,Long> {
    public  BusStops findByStopName(String stopName);
    public  BusStops findByStopNameAndRouteRouteId(String stopName, Long routeId);
    public List<BusStops> findByRouteRouteId(Long routeId);

    public BusStops findByBusBusIdAndStopName(Long busId, String stopName);
    public BusStops findByStopRank(Integer stopRank);
}
