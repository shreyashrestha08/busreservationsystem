package com.blume.busbackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CityLocater")
@NoArgsConstructor
@AllArgsConstructor
public class CityLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    private String cityName;
    private Double lat;
    private Double log;

}
