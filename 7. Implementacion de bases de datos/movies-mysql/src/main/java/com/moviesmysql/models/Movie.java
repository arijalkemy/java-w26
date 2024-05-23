package com.moviesmysql.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "length")
    private Integer length;

    @OneToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
