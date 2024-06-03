package com.bootcamp.hqlmovies.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private Timestamp releaseDate;

    @Column(name = "length")
    private Integer length;

    @OneToMany(mappedBy = "favoriteMovie")
    private List<Actor> actors;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    private List<ActorMovie> actorMovies;
}
