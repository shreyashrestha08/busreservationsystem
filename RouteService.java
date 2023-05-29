package com.blume.busbackend.service;

import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;

import java.util.List;
public interface RouteService {
    Route create(Route route);
    List<Route> getAll();
    List<Route> getbysourceanddestination(String origin, String destination);
    Route findById(Long routeId);
    void delete(Long routeId);
    Route edit(Route route);
    Long getbyName(String routeName);

    Route edit(Long id, Route route);

}