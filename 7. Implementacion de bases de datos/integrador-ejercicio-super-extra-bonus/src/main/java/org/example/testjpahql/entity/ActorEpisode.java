package org.example.testjpahql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @EmbeddedId
    private ActorEpisodeKey id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne
    @MapsId("episodeId")
    @JoinColumn(name = "episode_id", nullable = false)
    private Episode episode;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}