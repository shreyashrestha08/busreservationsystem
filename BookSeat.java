package com.blume.busbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookSeatId;

    private String busNo;
    private Long bookedOriginRank;
    private Long bookedDestRank;
    private String seatNo;
    private String date;
    private  String status;



}
