package com.example.miniseriesh2_vivo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mini_serie")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", length = 50)
    private String name;
    @Column(name="rating")
    private Double rating;
    @Column(name="amount_of_awards")
    private int amountOfAwards;
}
