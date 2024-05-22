package com.example.moviesexample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "episodes")
public class Episodes implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private String number;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "rating", nullable = false)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Seasons season_Id;

}
