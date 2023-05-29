package com.blume.busbackend.controller;


import com.blume.busbackend.Beans.BusBean;
import com.blume.busbackend.Beans.ScheduleBean;
import com.blume.busbackend.Beans.ScheduleBeaner;
import com.blume.busbackend.models.Bus;
import com.blume.busbackend.models.Schedule;
import com.blume.busbackend.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/add")
    Schedule create(@RequestBody ScheduleBean scheduleBean) {
        return scheduleService.create(scheduleBean);
    }
    @PostMapping("/addalls")
   List<Schedule> createall(@RequestBody List<ScheduleBean> scheduleBean) {
        return scheduleService.createall(scheduleBean);
    }
    @DeleteMapping("/delete/{id}")
    String deleteById(@PathVariable("id") Long id) {
        scheduleService.delete(id);
        return "Successfully Deleted " + id;
    }

    @GetMapping("/findall")
    List<ScheduleBeaner> findAll() {
        List<Schedule> scheduleList = scheduleService.getAll();
        List<ScheduleBeaner> scheduleBeanList = new ArrayList<>() ;
        for(Schedule schedule : scheduleList){
            ScheduleBeaner scheduleBean = new ScheduleBeaner();
            scheduleBean.setScheduleId(schedule.getScheduleId());
            scheduleBean.setBusName(schedule.getBus().getBusName());
            scheduleBean.setBusTime(schedule.getBusTime());
            scheduleBean.setStopName(schedule.getBusStops().getStopName());

            scheduleBeanList.add(scheduleBean);
        }
        return scheduleBeanList;

    }
    @GetMapping("/all")
    List<ScheduleBean> getAll() {

        return  scheduleService.getAll().stream().map(schedule -> modelMapper.map(schedule,ScheduleBean.class)).collect(Collectors.toList());
    }

    @GetMapping("/findbyid/{id}")
    Schedule findById(@PathVariable("id") Long id) {
        return  scheduleService.find(id);
    }

    @PutMapping("/update/{scheduleId}")
    Schedule updateSchedule(@PathVariable("scheduleId") Long schdeuleId , @RequestBody ScheduleBean scheduleBean ) {
        return scheduleService.edit(schdeuleId , scheduleBean);
    }

    @GetMapping("/findstopid/{busId}")
    Long findStopId(@PathVariable("busId") Long busId) {
        List<Schedule> schedules = scheduleService.findByBusId(busId);
        Long tempStopId = 0L;
        LocalTime now = LocalTime.now();
        for(Schedule schedule : schedules){
            LocalTime limit = LocalTime.parse(schedule.getBusTime());
            boolean isBefore = now.isBefore( limit );
            if(isBefore) {
                if(tempStopId == 0) {
                    tempStopId = schedule.getBusStops().getStopId();
                }
                break;
            }
            else{
                tempStopId = schedule.getBusStops().getStopId();
            }
        }
        return tempStopId;
    }

    @GetMapping("/findbybusid/{busId}")
    List<ScheduleBeaner> findByBusId(@PathVariable("busId") Long busId) {
        List<Schedule> scheduleList = scheduleService.findByBusId(busId);
        List<ScheduleBeaner> scheduleBeanList = new ArrayList<>() ;
        for(Schedule schedule : scheduleList){
            ScheduleBeaner scheduleBean = new ScheduleBeaner();
            scheduleBean.setScheduleId(schedule.getScheduleId());
            scheduleBean.setBusName(schedule.getBus().getBusName());
            scheduleBean.setBusTime(schedule.getBusTime());
            scheduleBean.setStopName(schedule.getBusStops().getStopName());

            scheduleBeanList.add(scheduleBean);
        }
        return scheduleBeanList;
    }


}
