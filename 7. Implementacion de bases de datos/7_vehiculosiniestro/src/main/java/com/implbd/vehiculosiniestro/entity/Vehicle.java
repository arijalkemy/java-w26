package com.implbd.vehiculosiniestro.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "vehicles")
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_vehicle")
    private Long idVehicle;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "created_year")
    private LocalDate createdYear;

    @Column(name = "wheels_quantity")
    private Integer wheelsQuantity;

}
