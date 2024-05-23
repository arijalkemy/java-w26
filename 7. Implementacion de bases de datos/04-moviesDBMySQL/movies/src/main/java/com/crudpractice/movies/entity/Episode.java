package com.crudpractice.movies.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name="episodes")
public class Episode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name= "number")
    private int numberOfEpisode;
    @Column(name= "release_date")
    private Date releaseDate;
    @Column(name= "rating")
    private double rating;
    @ManyToOne
    @JoinColumn(name= "season_id")
    private Season season;
    @ManyToMany
    @JoinTable(
            name= "actor_episode",
            joinColumns = @JoinColumn(name= "episode_id"),
            inverseJoinColumns = @JoinColumn(name= "actor_id")
    )
    private List<Actor> actorsInEpisode;
}
