package com.demospring.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mini_serie")
@Getter @Setter
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private double rating;

    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
