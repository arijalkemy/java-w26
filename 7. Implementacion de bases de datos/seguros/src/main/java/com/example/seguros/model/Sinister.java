package com.example.seguros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate date;
    private double EconomicLoss;

    @ManyToOne
    private Vehicle vehicle;

}
