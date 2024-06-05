package org.example.testjpahql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "actor_movie")
public class ActorMovie implements Serializable {
    @EmbeddedId
    private ActorMovieKey id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    @JsonBackReference
    private Actor actor;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;}
