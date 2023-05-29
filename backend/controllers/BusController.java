package com.blume.busbackend.controller;
import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.EmailDetails;
import com.blume.busbackend.service.BusService;
import com.blume.busbackend.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "http://localhost:3000")
public class BusController {

    @Autowired
    BusService busService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/add")
    Bus create(@RequestBody BusBean bus) {
        return busService.create(bus);
    }

    @PostMapping("/addall")
   List <Bus> createall(@RequestBody List<Bus> buses) {
        return busService.createall(buses);
    }

    @GetMapping("/all")
    List<BusBean> getAll() {
        return busService.getAll().stream().map(bus -> modelMapper.map(bus, BusBean.class)).collect(Collectors.toList());
    }

    @GetMapping("/allbus")
    List<Bus> getll() {
        return busService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    String deleteId(@PathVariable("id") Long id) {
        busService.delete(id);
        return "Successfully Deleted " + id;
    }

    @GetMapping("/find/{busId}")
    BusBean findId(@PathVariable("busId") Long busId) {
        Bus bus = busService.find(busId);
        return modelMapper.map(bus, BusBean.class);
    }


    @PutMapping("/update/{id}")
    Bus updateId(@PathVariable("id") Long id, @RequestBody BusBean busBean) {
        return busService.edit(id,busBean);
    }

    @GetMapping("/findbyrouteid/{routeId}")
    List<BusBean> findByrouteId(@PathVariable("routeId") Long routeId) {
        List<Bus> bus = busService.findByrouteId(routeId);
        List<BusBean> busBeans = bus.stream().map(bus1 -> modelMapper.map(bus1, BusBean.class)).toList();
        return busBeans;
    }
    @GetMapping("/findbybusname/{busName}")
    Long getbybn(@PathVariable("busName") String busName) {
        return busService.getbyName(busName);
    }

    @GetMapping("/findbyod/{origin}/{destination}")
    List<Bus> findByod(@PathVariable("origin") String origin, @PathVariable("destination") String destination)
    {
        return busService.findByod(origin, destination);
    }

}