package com.meli.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards ;
}
