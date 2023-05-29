package com.blume.busbackend.Beans;

import lombok.Data;

@Data
public class BusStopBeaner {




        private Long stopId;
        private String stopName;
        private Long stopDist;
        private Integer stopRank;
        private Double lat;
        private Double log;
        private String routeName;
        private String busName;
    }


