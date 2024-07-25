package com.val132005.parking.model.vehicle;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "plate", unique = true)
    private String plate;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "color")
    private String color;

    @Column(name = "make")
    private String make;

    @Column(name = "owner")
    private String owner;

    @Column(name = "model")
    private int model;

    @Column(name = "dayOfEntry")
    private Date dayOfEntry;

    @Column(name = "dayOfDeparture")
    private Date dayOfDeparture;

    @Column(name = "timeOfEntry")
    private Time timeOfEntry;

    @Column(name = "timeOfDeparture")
    private Time timeOfDeparture;



}
