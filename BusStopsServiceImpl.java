package com.blume.busbackend.service;

import com.blume.busbackend.Beans.BusStopBeaner;
import com.blume.busbackend.Beans.BusStopsBean;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.BusStops;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.repo.BusRepository;
import com.blume.busbackend.repo.BusStopsRepository;
import com.blume.busbackend.repo.RouteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusStopsServiceImpl implements BusStopsService{
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusRepository busRepository;
    @Autowired
    BusStopsRepository busStopsRepository;

    @Override
    public BusStops create(BusStopsBean busStops) {
        Route route = routeRepository.findById(busStops.getRouteId()).get();
        Bus bus = busRepository.findById(busStops.getBusId()).get();


        BusStops busStops1 = new BusStops();
        BeanUtils.copyProperties(busStops,busStops1,"routeId");
        busStops1.setRoute(route);
        BeanUtils.copyProperties(busStops,busStops1,"busId");
        busStops1.setBus(bus);
        return busStopsRepository.save(busStops1);
    }

    @Override
    public List<BusStops> createall(List<BusStopsBean> busStopes) {
        List<BusStops> busStopsList= new ArrayList<>();
       for(BusStopsBean busstop: busStopes){
        Route route = routeRepository.findById(busstop.getRouteId()).get();
           Bus bus = busRepository.findById(busstop.getBusId()).get();
        BusStops busStops1 = new BusStops();
        BeanUtils.copyProperties(busstop,busStops1,"routeId");
        busStops1.setRoute(route);
           BeanUtils.copyProperties(busstop,busStops1,"busId");
           busStops1.setBus(bus);
       busStopsList.add(busStops1);
       }
        return busStopsRepository.saveAll(busStopsList);
    }

    @Override
    public List<BusStops> createalls(List<BusStopBeaner> busStopess) {
        {
            List<BusStops> busStopsList= new ArrayList<>();
            for(BusStopBeaner busstop: busStopess){
                Route route = routeRepository.findByRouteName(busstop.getRouteName());
                Bus bus = busRepository.findByBusName(busstop.getBusName());
                BusStops busStops1 = new BusStops();
                BeanUtils.copyProperties(busstop,busStops1,"routeId");
                busStops1.setRoute(route);
                BeanUtils.copyProperties(busstop,busStops1,"busId");
                busStops1.setBus(bus);
                busStopsList.add(busStops1);
            }
            return busStopsRepository.saveAll(busStopsList);
        }

    }
//

    @Override
    public List<BusStops> getAll() {

        return busStopsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        busStopsRepository.deleteById(id);
    }

    @Override
    public BusStops find(Long id) {
        return busStopsRepository.findById(id).get();
    }

    @Override
    public BusStops edit(BusStopsBean busStops, Long stopId) {
        BusStops busStops1 = busStopsRepository.findById(stopId).get();
        Route route = routeRepository.findById(busStops.getRouteId()).get();
        Bus bus = busRepository.findById(busStops.getBusId()).get();
        busStops1.setStopName(busStops.getStopName());
        busStops1.setStopDist(busStops.getStopDist());
        busStops1.setStopRank(busStops.getStopRank());

        busStops1.setRoute(route);
        return busStopsRepository.save(busStops1);
    }

    @Override
    public BusStops findByStopName(String stopsName) {
        return busStopsRepository.findByStopName(stopsName);
    }


    @Override
    public BusStops findByStopRank(Integer stopRank) {
        return busStopsRepository.findByStopRank(stopRank);
    }

    @Override
    public List<BusStops> findByrouteId(Long routeId) {
        return busStopsRepository.findByRouteRouteId(routeId);
    }

    @Override
    public BusStops findbybusandname(Long busId, String stopName) {
        return busStopsRepository.findByBusBusIdAndStopName(busId, stopName);
    }


    @Override
    public BusStops findByrouteIdandName(String stopName, Long routeId) {
        return busStopsRepository.findByStopNameAndRouteRouteId(stopName, routeId);
    }


    @Override
    public Long getbyName(String stopName) {
        BusStops stopid= new BusStops();
        stopid=  busStopsRepository.findByStopName(stopName);
        return stopid.getStopId();
    }




}
