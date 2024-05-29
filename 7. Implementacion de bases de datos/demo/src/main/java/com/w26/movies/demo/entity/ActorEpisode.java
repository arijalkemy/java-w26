package com.w26.movies.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "actor_id", nullable = false)
    Actor actor;

    @OneToOne
    @JoinColumn(name = "episode_id", nullable = false)
    Episode episode;



    LocalDateTime created_at;
    LocalDateTime updated_at;

}
