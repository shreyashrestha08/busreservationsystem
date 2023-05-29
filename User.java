package com.blume.busbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BlumeUser")
public class User {
    @Id
    private String email;
    private String password;
    private String name;
    private String role;


    @JsonIgnore
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.REMOVE } , orphanRemoval = true)
    private List<Booking> bookingList;

}
