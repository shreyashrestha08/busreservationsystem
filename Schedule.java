package com.blume.busbackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "BusSchedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;
    private String busTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stop_id", nullable = false)
    @ToString.Exclude
    private BusStops busStops;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id" , nullable = false)
    @ToString.Exclude
    private  Bus bus;




}
