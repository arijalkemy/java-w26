package com.example._01miniseries.models;

import jakarta.persistence.*;

@Entity
@Table(name = "mini_Serie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
