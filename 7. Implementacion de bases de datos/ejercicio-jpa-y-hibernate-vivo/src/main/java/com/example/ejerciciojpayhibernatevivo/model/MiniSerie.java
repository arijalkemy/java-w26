package com.example.ejerciciojpayhibernatevivo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mini_serie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "amount_of_awards", length = 25)
    private int amount_of_awards;
}
