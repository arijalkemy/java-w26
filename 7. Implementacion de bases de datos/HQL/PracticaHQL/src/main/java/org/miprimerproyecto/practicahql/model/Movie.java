package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "awards")
    private Integer awards;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "length")
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "favoriteMovie")
    private Set<Actor> actors = new LinkedHashSet<>();

// Getters and setters
}