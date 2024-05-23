package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Data
public class Episode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "number")
    private Integer number;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "rating")
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "episode")
    private Set<ActorEpisode> actorEpisodes = new LinkedHashSet<>();

// Getters and setters
}