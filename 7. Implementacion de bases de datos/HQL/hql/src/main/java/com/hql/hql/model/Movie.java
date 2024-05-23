package com.hql.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table( name = "movies")
@Getter @Setter
public class Movie {
    @Id
    @GeneratedValue
    @Column( name = "id")
    private int id;
    @Column( name = "created_at")
    private LocalDateTime createdAt;
    @Column( name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private float rating;
    private int awards;
    @Column( name = "release_date")
    private LocalDateTime releaseDate;
    private Integer length;
    @ManyToOne
    @JoinColumn( name= "genre_id")
    private Genre genre;
}
