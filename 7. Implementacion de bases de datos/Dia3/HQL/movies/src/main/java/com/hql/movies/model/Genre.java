package com.hql.movies.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "created_at", nullable = true)
    private String createdAt;

    @Column(name = "updated_at", nullable = true)
    private String updatedAt;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "ranking", nullable = true)
    private Integer ranking;

    @Column(name = "active", nullable = true)
    private Integer active;
}
