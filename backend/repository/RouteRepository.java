package com.blume.busbackend.repo;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    public List<Route> findByOriginAndDestination(String origin, String destination);
    public Route findByRouteName(String routeName);
}