package org.example.movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "episodes", schema = "movies_db")
@Data
@EqualsAndHashCode
public class EpisodesEntity {
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
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Basic
    @Column(name = "rating")
    private Double rating;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    private SeasonsEntity seasons;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "episodes", cascade = CascadeType.ALL)
    private List<ActorEpisodeEntity> actorEpisodeList;
}
