package com.hql.hql.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table( name = "actor_movie")
public class ActorsByMovies {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn( name = "movie_id")
    private Movie movie;
    @Column( name = "created_at")
    private LocalDateTime createdAt;
    @Column( name = "updated_at")
    private LocalDateTime updatedAt;
}
