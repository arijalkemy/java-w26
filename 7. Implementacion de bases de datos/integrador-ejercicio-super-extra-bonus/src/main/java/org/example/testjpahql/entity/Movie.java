package org.example.testjpahql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "length")
    private Integer length;

    @OneToMany(mappedBy = "favouriteMovieId")
    private List<Actor> favouriteMoviesFromActors;

    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreMovieId;



}
