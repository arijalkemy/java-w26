package org.example.movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "actor_episode", schema = "movies_db")
@Data
@EqualsAndHashCode
public class ActorEpisodeEntity {
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorsEntity actors;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "episode_id")
    private EpisodesEntity episodes;
}
