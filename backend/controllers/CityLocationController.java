package com.blume.busbackend.controller;


import com.blume.busbackend.models.CityLocation;
import com.blume.busbackend.service.CityLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/city")
public class CityLocationController {
    @Autowired
    CityLocationService cityLocationService;

    @PostMapping("/add")
    CityLocation create(@RequestBody CityLocation cityLocation) {
        return cityLocationService.create(cityLocation);
    }

    @PostMapping("/addall")
    List<CityLocation> createall(@RequestBody List<CityLocation> cityLocations) {
        return cityLocationService.createall(cityLocations);
    }

    @GetMapping("/all")
    List<CityLocation> getAll() {
        return cityLocationService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    void  deleteById(@PathVariable("id") Long id){
        cityLocationService.delete(id);
    }

    @GetMapping("/findbyid/{id}")
    CityLocation findById(@PathVariable("id") Long id) {
        return cityLocationService.find(id);
    }

    @GetMapping("/findbyname/{cityName}")
    CityLocation findByName(@PathVariable("cityName") String cityName){
        return cityLocationService.findByCityName(cityName);
    }

}
