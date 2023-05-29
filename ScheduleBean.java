package com.blume.busbackend.Beans;


import lombok.Data;

import java.sql.Time;

@Data
public class ScheduleBean {

    private Long scheduleId;
    private Long stopId;
    private Long busId;
    private String busTime;
}
