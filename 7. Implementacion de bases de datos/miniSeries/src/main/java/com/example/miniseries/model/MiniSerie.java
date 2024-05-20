package com.example.miniseries.model;

import jakarta.persistence.*;

@Entity
@Table(name = "miniseries")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Basic
    private String name;
    @Basic
    private double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
