package com.example.movieshqlasync.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @Column(name= "created_at", nullable = true)
    LocalDate createdAt;
    @Column(name= "updated_at", nullable = true)
    LocalDate updatedAt;
    private Double rating;
    private int awards;
    private int length;
    @Column(name = "genre_id")
    private int genreId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private List<ActorMovie> actorMovies;
}
