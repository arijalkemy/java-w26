package com.ejercicio.segurosdeautos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String patent;
    private String brand;
    private String model;
    private LocalDate febricationYear; // Changed from 'int' to 'LocalDate'
    private int wheels;

    @OneToMany(mappedBy = "vehicle")
    private List<Sinister> reported;
}