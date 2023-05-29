package com.blume.busbackend.service;

import com.blume.busbackend.models.CityLocation;
import com.blume.busbackend.repo.CityLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityLocationServiceImpl implements CityLocationService{

    @Autowired
    CityLocationRepository cityLocationRepository;

    @Override
    public CityLocation create(CityLocation cityLocation) {
        return cityLocationRepository.save(cityLocation);
    }

    @Override
    public List<CityLocation> createall(List<CityLocation> cityLocations) {
        return cityLocationRepository.saveAll(cityLocations);
    }

    @Override
    public List<CityLocation> getAll() {
        return cityLocationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        cityLocationRepository.deleteById(id);
    }

    @Override
    public CityLocation find(Long id) {
        return cityLocationRepository.findById(id).get();
    }

    @Override
    public CityLocation findByCityName(String cityName) {
        return cityLocationRepository.findByCityName(cityName);
    }
}
