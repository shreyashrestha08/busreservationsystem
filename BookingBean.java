package com.blume.busbackend.Beans;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class BookingBean {
    private Long bookingId;
    private Integer fare;
    private String seatNo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String origin;
    private String destination;
    private Long age;
    private String name;
    private String gender;
    private String busNo;
    private String email;
    private Long bookSeatId;

}
