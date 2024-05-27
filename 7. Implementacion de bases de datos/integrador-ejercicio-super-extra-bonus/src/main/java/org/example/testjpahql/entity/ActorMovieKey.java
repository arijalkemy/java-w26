package org.example.testjpahql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@Embeddable
public class ActorMovieKey implements Serializable {
    @Column(name = "actor_id")
    private Integer actorId;

    @Column(name = "movie_id")
    private Integer movieId;
}
