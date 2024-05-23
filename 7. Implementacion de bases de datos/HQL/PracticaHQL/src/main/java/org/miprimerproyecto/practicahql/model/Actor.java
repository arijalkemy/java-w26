package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "rating")
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

    @OneToMany(mappedBy = "actor")
    private Set<ActorEpisode> actorEpisodes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "actor")
    private Set<ActorMovie> actorMovies = new LinkedHashSet<>();


    // Getters and setters
}