package com.bootcamp.MiniSeries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
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

    public MiniSerie() {
    }

    public MiniSerie(Long id, String name, Double rating, int amountOfAwards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.amountOfAwards = amountOfAwards;
    }


}
