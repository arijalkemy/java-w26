package com.example.moviesexample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actor_episode")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorEpisode implements java.io.Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "actors_id", nullable = false)
    private Actors actors_id;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episodes episode_id;


}
