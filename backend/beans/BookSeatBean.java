package com.blume.busbackend.Beans;


import lombok.Data;

@Data
public class BookSeatBean {
    private String busNo;
    private Long originStopRank;
    private Long destStopRank;
    private String date;
    private String seatNo;
    private  String status;
}
