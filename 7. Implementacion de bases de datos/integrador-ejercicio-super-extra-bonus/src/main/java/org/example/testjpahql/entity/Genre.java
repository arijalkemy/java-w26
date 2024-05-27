package org.example.testjpahql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "genreMovieId")
    private List<Movie> movies;

    @OneToMany(mappedBy = "genreSerieId")
    private List<Serie> series;
}
