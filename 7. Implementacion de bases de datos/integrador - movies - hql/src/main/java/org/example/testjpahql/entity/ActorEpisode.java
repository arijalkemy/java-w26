package org.example.testjpahql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "actor_episode")
public class ActorEpisode implements Serializable {
    @EmbeddedId
    private ActorEpisodeKey id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    @JsonBackReference
    private Actor actor;

    @ManyToOne
    @MapsId("episodeId")
    @JoinColumn(name = "episode_id")
    @JsonBackReference
    private Episode episode;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}