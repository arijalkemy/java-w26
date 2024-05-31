package org.example.testjpahql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@Entity
@Table (name = "actors")
public class Actor {
    @Id
    @Column(name = "id")
    private Integer actorId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", nullable = false)
    private Movie favouriteMovieId;

    @OneToMany(mappedBy = "actor")
    private Set<ActorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private Set<ActorEpisode> actorEpisodes;
}
