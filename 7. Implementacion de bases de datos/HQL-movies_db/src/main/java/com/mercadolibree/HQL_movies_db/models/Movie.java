package com.mercadolibree.HQL_movies_db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Entity(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDateTime date;
    private Double rating;
    @Column(name = "genre_id")
    private int genreId;
    @OneToMany
    private List<Actor> actors;
}
