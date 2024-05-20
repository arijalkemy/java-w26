package com.example.miniseries2.model;

import com.example.miniseries2.enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name="rating")
    Double rating;
    @Column(name = "amount_of_awards")
    Integer amountOfAwards;
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    GeneroEnum genre;
}
