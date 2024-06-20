package com.example.seguros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String patent;
    private String brand;
    private String model;
    private int yearProduction;
    private int numberWheels;

    @OneToMany(mappedBy = "vehicle")
    private List<Sinister> sinisters;


}
