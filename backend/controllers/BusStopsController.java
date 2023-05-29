package com.blume.busbackend.controller;

import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.Beans.BusStopBeaner;
import com.blume.busbackend.Beans.BusStopsBean;
import com.blume.busbackend.models.BookSeat;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.BusStops;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.repo.BusRepository;
import com.blume.busbackend.repo.BusStopsRepository;
import com.blume.busbackend.service.BusStopsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stops")
public class BusStopsController {
    @Autowired
    BusStopsService busStopsService;
    @Autowired
    BusStopsRepository busStopsRepository;

    @Autowired
    ModelMapper modelMapper;
    //creating new stop
    @PostMapping("/add")
    BusStops create(@RequestBody BusStopsBean busStops) {
        return busStopsService.create(busStops);
    }
    //Getting all stops

    @PostMapping("/addall")
    List<BusStops> createall(@RequestBody List<BusStopsBean> busStopes) {
        return busStopsService.createall(busStopes);
    }
    //Getting all stops

    @PostMapping("/addalls")
    List<BusStops> createalls(@RequestBody List<BusStopBeaner> busStopess) {
        return busStopsService.createalls(busStopess);
    }
    //Getting all stops

    @GetMapping("/all")
    List<BusStopsBean> getAll() {
//        List<BusStopsBean> busStopsBean = busStopsService.getAll().stream().map(busStop -> modelMapper.map(busStop, BusStopsBean.class)).collect(Collectors.toList());
//        List<BusStops> busStopsList = busStopsService.getAll();
        return  busStopsService.getAll().stream().map(busStop -> modelMapper.map(busStop, BusStopsBean.class)).collect(Collectors.toList());
    }
    //Delete Stops using stopId
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id) {
        busStopsService.delete(id);
    }
    //find By id
    @GetMapping("/find/{id}")
    BusStopsBean find(@PathVariable("id") Long id) {
        BusStops busStops = busStopsService.find(id);
        BusStopsBean busStopsBean = modelMapper.map(busStops,BusStopsBean.class);
        return busStopsBean;
    }

    //find stop using stopName
    @GetMapping("/findbyname/{stopName}")
    BusStopsBean findBystopName(@PathVariable("stopName") String stopName) {
        BusStops busStops = busStopsService.findByStopName(stopName);
        BusStopsBean busStopsBean = modelMapper.map(busStops,BusStopsBean.class);
        busStopsBean.setRouteId(busStops.getRoute().getRouteId());
        return busStopsBean;
    }




    @GetMapping("/findbyrank/{stopRank}")
    BusStopsBean findBystopRank(@PathVariable("stopRank") Integer stopRank) {
        BusStops busStops = busStopsService.findByStopRank(stopRank);
        BusStopsBean busStopsBean = modelMapper.map(busStops,BusStopsBean.class);
        busStopsBean.setRouteId(busStops.getRoute().getRouteId());
        return busStopsBean;
    }

    @GetMapping("/findbystopname/{stopName}")
    Long getbysn(@PathVariable("stopName") String stopName) {
        return busStopsService.getbyName(stopName);
    }

    @PutMapping("/updatestop/{stopId}")
    BusStops updateStops(@PathVariable("stopId") Long stopId , @RequestBody BusStopsBean busStops) {
        return  busStopsService.edit(busStops , stopId);
    }

    @GetMapping("/findbyrouteid/{routeId}")
    List<BusStopsBean> findByrouteId(@PathVariable("routeId") Long routeId) {
        List<BusStops> busStops = busStopsService.findByrouteId(routeId);
        return busStops.stream().map(busStops1 -> modelMapper.map(busStops1, BusStopsBean.class)).toList();
    }

    @GetMapping("/findbyrouteandname/{stopName}/{routeId}")
    Long findbyroutenname(@PathVariable("stopName") String stopName, @PathVariable("routeId") Long routeId) {
        BusStops busStoprnn = busStopsService.findByrouteIdandName(stopName, routeId);
        return busStoprnn.getStopId();
    }


}
