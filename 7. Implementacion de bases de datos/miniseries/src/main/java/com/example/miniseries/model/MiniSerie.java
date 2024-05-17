package com.example.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mini_serie")

public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
