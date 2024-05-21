package com.mercadolibre.projectname.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Float rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "actor_movie")
    private Set<Movie> moviesActed;

    @ManyToMany(mappedBy = "actor_episode")
    private Set<Episode> episodesActed;
}
