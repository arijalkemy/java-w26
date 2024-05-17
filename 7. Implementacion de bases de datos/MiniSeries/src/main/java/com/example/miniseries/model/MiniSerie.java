package com.example.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

@Getter @Setter
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column
    String name;
    @Column
    Double rating;
    @Column
    int amount_of_awards;
}
