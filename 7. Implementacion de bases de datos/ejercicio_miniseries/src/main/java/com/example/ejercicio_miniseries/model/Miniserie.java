package com.example.ejercicio_miniseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="miniseries")
public class Miniserie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column()
    private String name;

    @Column()
    private double rating;

    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
