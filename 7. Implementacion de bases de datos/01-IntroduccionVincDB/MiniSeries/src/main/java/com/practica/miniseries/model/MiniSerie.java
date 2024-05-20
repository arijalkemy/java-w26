package com.practica.miniseries.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    private Integer amountOfAwards;
}
