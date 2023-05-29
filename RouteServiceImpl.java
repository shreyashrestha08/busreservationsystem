package com.blume.busbackend.service;
import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.repo.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteRepository routeRepository;

    @Override
    public Route create(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getAll() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> getbysourceanddestination(String origin, String destination) {
        return routeRepository.findByOriginAndDestination(origin, destination);
    }

    @Override
    public Route findById(Long routeId) {
        return routeRepository.findById(routeId).get();
    }

    @Override
    public void delete(Long routeId) {
        routeRepository.deleteById(routeId);
    }

    @Override
    public Route edit(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Long getbyName(String routeName) {
        Route routeid= new Route();
      routeid=  routeRepository.findByRouteName(routeName);
       return routeid.getRouteId();
    }

    @Override
    public Route edit(Long id, Route route) {

            Route route1 = routeRepository.findById(id).get();

            route1.setRouteName(route.getRouteName());
            route1.setOrigin(route.getOrigin());
            route1.setDestination(route.getDestination());

            return routeRepository.save(route1);
        }
    }


