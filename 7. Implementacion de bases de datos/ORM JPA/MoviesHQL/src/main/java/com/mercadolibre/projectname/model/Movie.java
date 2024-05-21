package com.mercadolibre.projectname.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "movies")
@NoArgsConstructor @AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private Float rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Integer length;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "movie_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "actor_id", nullable = false),
            name = "actor_movie"
    )
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
