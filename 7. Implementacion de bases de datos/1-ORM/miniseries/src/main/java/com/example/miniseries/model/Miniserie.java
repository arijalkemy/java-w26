package com.example.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name="miniserie")
public class Miniserie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="rating")
    private Double rating;
    @Column(name="amount_of_awards")
    private int amount_of_awards;
}
