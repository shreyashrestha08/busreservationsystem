package com.blume.busbackend.service;

import com.blume.busbackend.Beans.BusStopBeaner;
import com.blume.busbackend.Beans.BusStopsBean;
import com.blume.busbackend.models.BookSeat;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.BusStops;
import com.blume.busbackend.models.Route;


import java.util.List;

public interface BusStopsService {
    BusStops create(BusStopsBean busStops);

    List<BusStops> createall(List<BusStopsBean> busStopes);

    List<BusStops> createalls(List<BusStopBeaner> busStopess);
    List<BusStops> getAll();
    void delete(Long id);
    BusStops find(Long id);
    BusStops edit(BusStopsBean busStops , Long stopId);
    BusStops findByStopName(String stopsName);

    BusStops findByStopRank(Integer stopRank);
    List<BusStops> findByrouteId(Long routeId);
    BusStops findbybusandname(Long busId, String stopName);
    BusStops findByrouteIdandName(String stopName, Long routeId);
    Long getbyName(String stopName);



}
