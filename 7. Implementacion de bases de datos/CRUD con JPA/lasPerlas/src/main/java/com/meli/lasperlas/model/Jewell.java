package com.meli.lasperlas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Jewells")
public class Jewell {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String material;
    private int weight;
    private String particularity;
    private Boolean has_stone;
    private Boolean for_sale;
}
