package com.example.movieshqlasync.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ActorMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @Column(name = "movie_id")
    private int movieId;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;
}
