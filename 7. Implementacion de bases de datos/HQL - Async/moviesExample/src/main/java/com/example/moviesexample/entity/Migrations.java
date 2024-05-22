package com.example.moviesexample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "migrations")
public class Migrations implements Serializable {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "migration", nullable = false)
    private String migration;

    @Column(name = "batch", nullable = false)
    private Integer batch;

}
