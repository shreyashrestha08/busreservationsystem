package com.blume.busbackend.controller;

import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("/all")
    List<Route> getAll() {
        return routeService.getAll();
    }

    @GetMapping("/{origin}/{destination}")
    List<Route> getbysandd(@PathVariable("origin") String origin, @PathVariable("destination") String destination) {
        return routeService.getbysourceanddestination(origin, destination);
    }
    @GetMapping("/findbyroutename/{routeName}")
    Long getbyrn(@PathVariable("routeName") String routeName) {
        return routeService.getbyName(routeName);
    }

    @PostMapping("/add")
    Route create(@RequestBody Route route) {
        return routeService.create(route);
    }

    @PostMapping("/edit")
    Route update(@RequestBody Route route) {
        return routeService.create(route);
    }

    @GetMapping("/find/{id}")
    Route findById(@PathVariable("id") Long routeId) {
        return routeService.findById(routeId);
    }


    @PutMapping("/update/{id}")
    Route updateId(@PathVariable("id") Long id, @RequestBody Route route) {
        return routeService.edit(id,route);
    }

    @DeleteMapping("/delete/{id}")
    String deleteId(@PathVariable("id") Long id) {
        routeService.delete(id);
        return "Deleted " + id;
    }
}
