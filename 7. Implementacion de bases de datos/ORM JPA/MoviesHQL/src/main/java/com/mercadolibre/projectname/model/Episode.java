package com.mercadolibre.projectname.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Float rating;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "episode_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "actor_id", nullable = false),
            name = "actor_episode"
    )
    private Set<Actor> actors;
}
