package org.example.integradorvehiculossiniestros.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "fabrication_date")
    private LocalDateTime fabricationDate;

    @Column(name = "wheels")
    private Integer wheels;

    @OneToMany(mappedBy = "vehicle")
    private Set<AccidentRegistry> accidentRegistries;

}
