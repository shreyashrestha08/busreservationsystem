package com.blume.busbackend.Beans;

import lombok.Data;

import java.sql.Time;

@Data
public class ScheduleBeaner {
    private Long scheduleId;
    private String busTime;
    private String busName;
    private String stopName;
}
