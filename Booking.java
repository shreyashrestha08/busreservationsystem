package com.blume.busbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId; //automatic
    private Integer fare; //busData
    private String seatNo; //booking form
    @Temporal(TemporalType.TIMESTAMP)
    private Date date; //form data
    private String origin;   //form data
    private String destination; //form data
    private String name;
    private String gender;
    private Long age;
    private String busNo;
    private Long bookSeatId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email",nullable = false)
    @ToString.Exclude
    private User user; //booking form
}
