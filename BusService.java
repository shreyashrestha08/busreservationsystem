package com.blume.busbackend.service;


import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.models.Bus;

import java.util.List;

public interface BusService {

    List<Bus> createall(List<Bus> buses);
    Bus create(BusBean bus);
    List<Bus> getAll();
    Bus edit(Long id,BusBean bus);
    void delete(Long busId);
    Bus find(Long busId);
    List<Bus> findByod(String origin, String destination);
    List<Bus> findByrouteId(Long routeId);
    Long getbyName(String BusName);

    List<List<Bus>> findByrouteIds(List<Long> routeIds);
}
