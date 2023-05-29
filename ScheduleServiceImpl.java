package com.blume.busbackend.service;

import com.blume.busbackend.Beans.ScheduleBean;
import com.blume.busbackend.Beans.ScheduleBeaner;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.BusStops;
import com.blume.busbackend.models.Schedule;
import com.blume.busbackend.repo.BusRepository;
import com.blume.busbackend.repo.BusStopsRepository;
import com.blume.busbackend.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusStopsRepository busStopsRepository;

    @Override
    public Schedule create(ScheduleBean scheduleBean) {
        Schedule schedule = new Schedule();
        Bus bus = busRepository.findById(scheduleBean.getBusId()).get();
        BusStops busStops = busStopsRepository.findById(scheduleBean.getStopId()).get();
        schedule.setBus(bus);
        schedule.setBusStops(busStops);
        schedule.setBusTime(scheduleBean.getBusTime());
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> createall(List<ScheduleBean> scheduleBean) {
        List<Schedule> schedulelist = new ArrayList<>();
        for(ScheduleBean sch: scheduleBean) {

            Schedule schedule = new Schedule();
            Bus bus = busRepository.findById(sch.getBusId()).get();
            BusStops busStops = busStopsRepository.findById(sch.getStopId()).get();

            schedule.setBus(bus);
            schedule.setBusStops(busStops);
            schedule.setBusTime(sch.getBusTime());
            schedulelist.add(schedule);
        }
        return scheduleRepository.saveAll(schedulelist);
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule edit(Long id, ScheduleBean schedule) {
        Schedule schedule1 = scheduleRepository.findById(id).get();
        Bus bus = busRepository.findById(schedule.getBusId()).get();
        BusStops busStops = busStopsRepository.findById(schedule.getStopId()).get();
        schedule1.setBusTime(schedule.getBusTime());
        schedule1.setBus(bus);
        schedule1.setBusStops(busStops);
        return scheduleRepository.save(schedule1);

    }

    @Override
    public void delete(Long scheduleId) {
            scheduleRepository.deleteById(scheduleId);
    }

    @Override
    public Schedule find(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).get();
    }

    @Override
    public List<Schedule> findByBusId(Long busId) {
        return scheduleRepository.findByBusBusId(busId);
    }
}
