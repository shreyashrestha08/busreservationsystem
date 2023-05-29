package com.blume.busbackend.Beans;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;

@Data
public class BusBean {
    private Long busId;
    private String busName;
    private String busNo;
    private Integer busCapacity;
    private Long routeId;
    private String busTime;
    private Integer fare;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}
