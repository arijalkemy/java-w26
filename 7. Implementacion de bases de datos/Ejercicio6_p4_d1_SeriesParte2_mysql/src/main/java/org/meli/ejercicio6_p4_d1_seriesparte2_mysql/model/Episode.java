package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    // Getters and setters
}
