package com.movieshql.trash;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes;

    // Getters and setters
}
