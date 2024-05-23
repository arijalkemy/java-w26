package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actor_episode", schema = "movies_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorEpisode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actors actor;

    @ManyToOne
    @JoinColumn(name = "episode_id", nullable = false)
    private Episodes episode;

}
