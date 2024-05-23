package com.crudpractice.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "movies")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "awards")
    private Integer awards;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "length")
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToMany
    @JoinTable(
            name= "actor_movie",
            joinColumns = @JoinColumn(name= "movie_id"),
            inverseJoinColumns = @JoinColumn(name= "actor_id")
    )
    @JsonManagedReference
    private List<Actor> actorsInMovie;
}