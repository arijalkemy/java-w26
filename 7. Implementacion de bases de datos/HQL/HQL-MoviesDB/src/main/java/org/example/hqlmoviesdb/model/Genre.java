package org.example.hqlmoviesdb.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    String name;
    int ranking;
    boolean active;
}
