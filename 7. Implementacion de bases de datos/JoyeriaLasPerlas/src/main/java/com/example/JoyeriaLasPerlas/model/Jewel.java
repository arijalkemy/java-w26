package com.example.JoyeriaLasPerlas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "JEWELS")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String material;
    private int weight;
    private String description;
    private Boolean hasStone;
    private Boolean isOnSale;
}
