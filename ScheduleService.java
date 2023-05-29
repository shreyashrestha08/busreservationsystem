package com.blume.busbackend.service;


import com.blume.busbackend.Beans.ScheduleBean;
import com.blume.busbackend.Beans.ScheduleBeaner;
import com.blume.busbackend.models.Schedule;

import java.util.List;

public interface ScheduleService {

    Schedule create(ScheduleBean scheduleBean);
    List<Schedule> createall(List<ScheduleBean> scheduleBean);
    List<Schedule> getAll();
    Schedule edit(Long id,ScheduleBean schedule);
    void delete(Long scheduleId);
    Schedule find(Long scheduleId);

    List<Schedule> findByBusId(Long busId);
}
