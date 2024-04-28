package org.example.integradorcodereview.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private Integer year;
    private String color;
    private Double max_speed;
    private String fuel_type;
    private String transmission;
    private Integer passengers; // # of people
    private Double height;
    private Double width;
    private Double weight;
}
