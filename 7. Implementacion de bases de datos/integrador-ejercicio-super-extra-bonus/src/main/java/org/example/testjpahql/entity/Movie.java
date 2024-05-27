package org.example.testjpahql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Setter @Getter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer movieId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "length")
    private Integer length;

    @OneToMany(mappedBy = "favouriteMovieId")
    private List<Actor> favouriteMoviesFromActors;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreMovieId;



}
