package com.example.moviesexample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "genres")
public class Genres implements Serializable {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ranking", nullable = false)
    private String ranking;

    @Column(name = "active", nullable = false)
    private Integer active;

}
