package com.ejercicio.showroom.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long code;

    private String name;
    private String type;
    private String brand;
    private String colour;
    private String waist;
    private int quantity;
    private double price;
}
