package org.example.movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actors", schema = "movies_db")
@Data
@EqualsAndHashCode
public class ActorsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "rating")
    private Double rating;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actors", cascade = CascadeType.ALL)
    private List<ActorEpisodeEntity> actorEpisodeList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_movie_id")
    private MoviesEntity movies;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actors", cascade = CascadeType.ALL)
    private List<ActorMovieEntity> actorMovieList;
}
