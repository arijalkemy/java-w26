package org.example.testjpahql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@Embeddable
public class ActorEpisodeKey implements Serializable {
    @Column(name = "actor_id")
    private Integer actorId;

    @Column(name = "episode_id")
    private Integer episodeId;
}
