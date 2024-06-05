package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "ranking", nullable = false, unique = true)
    private Integer ranking;

    @Column(name = "active", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean active;
    // Constructor, getters, and setters
}
