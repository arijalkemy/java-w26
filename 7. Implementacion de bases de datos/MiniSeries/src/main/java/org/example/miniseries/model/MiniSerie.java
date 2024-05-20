package org.example.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "miniseries")
@Getter
@Setter
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;

    public MiniSerie() {
    }

    public MiniSerie(Long id, String name, Double rating, int amount_of_awards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.amount_of_awards = amount_of_awards;
    }
}
