package com.blume.busbackend.Beans;

import lombok.Data;

@Data
public class BusStopsBean {
    private Long stopId;
    private String stopName;
    private Long stopDist;
    private Integer stopRank;
    private Double lat;
    private Double log;
    private Long routeId;
    private Long busId;
}
