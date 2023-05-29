package com.blume.busbackend.service;
import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Route;
import com.blume.busbackend.repo.BusRepository;
import com.blume.busbackend.repo.RouteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusRepository busRepository;


    @Override
    public List<Bus> createall(List<Bus> buses) {

        return busRepository.saveAll(buses);
    }

    @Override
    public Bus create(BusBean bus) {
        Route route = routeRepository.findById(bus.getRouteId()).get();
        Bus bus1 = new Bus();
        BeanUtils.copyProperties(bus,bus1,"routeId");
        bus1.setRoute(route);
        return busRepository.save(bus1);
    }

    @Override
    public List<Bus> getAll() {
//        List<Bus> buses =  busRepository.findAll();
//        List<BusBean> busBeans = new ArrayList<>();
//        for (bus:buses
//             ) {
//            BusBean busBean =
//            busBeans.add
//        }
        return busRepository.findAll();
    }

    @Override
    public Bus edit(Long id ,  BusBean bus) {
        Bus bus1 = busRepository.findById(id).get();
        Route route = routeRepository.findById(bus.getRouteId()).get();
        bus1.setBusNo(bus.getBusNo());
        bus1.setBusName(bus.getBusName());
        bus1.setBusTime(bus.getBusTime());

        bus1.setBusCapacity(bus.getBusCapacity());

        bus1.setRoute(route);
        bus1.setCreatedDate(bus.getCreatedDate());
        return busRepository.save(bus1);
    }

    @Override
    public void delete(Long busId) {
        busRepository.deleteById(busId);
    }

    @Override
    public Bus find(Long busId) {
        return busRepository.findById(busId).get();
    }

    @Override
    public List<Bus> findByod(String origin, String destination) {
       List<Bus> od= busRepository.findAll();

        return od.stream().filter(b-> {
            return b.getRoute().getOrigin().equals(origin) &&
                    b.getRoute().getDestination().equals(destination);
        }).collect(Collectors.toList());

    }

    @Override
    public List<Bus> findByrouteId(Long routeId) {
        return busRepository.findByRouteRouteId(routeId);
    }

    @Override
    public Long getbyName(String BusName) {

        Bus busid= new Bus();
        busid=  busRepository.findByBusName(BusName);
        return busid.getBusId();
    }

    @Override
    public List<List<Bus>> findByrouteIds(List<Long> routeIds) {
        List<List<Bus>> busesroute= new ArrayList<>();
        for(Long routeid: routeIds){
            busesroute.add(busRepository.findByRouteRouteId(routeid));
        }
        return busesroute;
    }

}
