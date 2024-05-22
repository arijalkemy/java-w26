package com.hql.movies.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = true)
    private String createdAt;

    @Column(name = "updated_at", nullable = true)
    private String updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private double rating;

    @Column(name = "favorite_movie_id")
    private Integer favoriteMovie;

    private int awards;
    private LocalDate release_date;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "actors")
    private Set<Serie> series;
}