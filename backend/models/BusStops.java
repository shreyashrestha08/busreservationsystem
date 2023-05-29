package com.blume.busbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BusStops")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusStops {
    @Id
    @SequenceGenerator(
            name = "stops_sequence",
            sequenceName = "stops_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stops_sequence"
    )
    private Long stopId;

    private String stopName;
    private Long stopDist;
    private Integer stopRank;
    private Double lat;
    private Double log;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id", nullable = false)
    @ToString.Exclude
    private Route route;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id", nullable = false)
    @ToString.Exclude
    private Bus bus;

    @JsonIgnore
    @OneToMany(mappedBy = "busStops" ,fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.REMOVE } , orphanRemoval = true)
    private List<Schedule> schedules;


}
