package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actor_movie", schema = "movies_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorMovie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actors actor;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;
}
