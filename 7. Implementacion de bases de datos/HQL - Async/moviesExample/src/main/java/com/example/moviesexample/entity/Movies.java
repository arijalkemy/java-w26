package com.example.moviesexample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rating", nullable = false)
    private BigDecimal rating;

    @Column(name = "awards", nullable = false)
    private String awards;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "length")
    private String length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genreId;

}
