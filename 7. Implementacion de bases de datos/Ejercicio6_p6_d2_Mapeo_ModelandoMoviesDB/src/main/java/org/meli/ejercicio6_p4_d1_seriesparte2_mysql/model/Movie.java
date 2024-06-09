package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards", nullable = false)
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "length")
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    // Constructor, getters, and setters
}
