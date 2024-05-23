package com.crudpractice.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "actors")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "rating")
    private Double rating;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;
    @ManyToMany(mappedBy = "actorsInMovie")
    @JsonBackReference
    private List<Movie> movies;
}
