package com.blume.busbackend.repo;

import com.blume.busbackend.models.CityLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityLocationRepository extends JpaRepository<CityLocation  , Long> {
    public CityLocation findByCityName(String cityName);
}
