package org.example.testjpahql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer episodeId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "episodes")
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

}
