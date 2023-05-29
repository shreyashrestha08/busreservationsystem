package com.blume.busbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BlumeBus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long busId;
    private String busName;
    private String busNo;
    private String busType;
    private Integer busCapacity;
    private Integer fare;
    private Integer speed;
    private String busTime;

    //we need bus start time

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id",nullable = false)
    @ToString.Exclude
    private Route route;



    @JsonIgnore
    @OneToMany(mappedBy = "bus" , fetch = FetchType.LAZY ,
            cascade = {CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.REMOVE } , orphanRemoval = true )
    private List<Schedule> schedules;

    @JsonIgnore
    @OneToMany(mappedBy = "bus" , fetch = FetchType.LAZY ,
            cascade = {CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.REMOVE } , orphanRemoval = true )
    private List<BusStops> stops;
}
