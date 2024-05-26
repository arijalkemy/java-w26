package com.example.HQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "ranking", nullable = false)
    private Integer ranking;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
