package com.blume.busbackend.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BlumeRoute")
public class Route {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO

    )
    private Long routeId;
    @Column(name = "route_name", unique = true)
    private String routeName;
    private String origin;

    private String destination;

    @JsonIgnore
    @OneToMany(mappedBy="route", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE} , orphanRemoval = true)
    private List<Bus> buses;

    @JsonIgnore
    @OneToMany(mappedBy = "route" ,fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.REMOVE } , orphanRemoval = true)
    private List<BusStops> busStops;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date startDateTime;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date arrivalDateTime;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDateTime;
}