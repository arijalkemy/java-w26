package com.bootcamp.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "miniseries")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private Double rating;
    @Column
    private int amount_of_awards;
}
