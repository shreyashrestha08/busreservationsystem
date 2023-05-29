package com.blume.busbackend.service;

import com.blume.busbackend.Beans.BusStopsBean;
import com.blume.busbackend.models.BusStops;
import com.blume.busbackend.models.CityLocation;

import java.util.List;

public interface CityLocationService {
    CityLocation create(CityLocation cityLocation);

    List<CityLocation> createall(List<CityLocation> cityLocations);
    List<CityLocation> getAll();
    void delete(Long id);
    CityLocation find(Long id);
    CityLocation findByCityName(String cityName);
}
