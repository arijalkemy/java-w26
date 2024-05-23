package org.example.movieshql.model;


import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;

@Data
@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private Episode episode;

    // Getters and setters
    // You can also include constructors if needed
}

