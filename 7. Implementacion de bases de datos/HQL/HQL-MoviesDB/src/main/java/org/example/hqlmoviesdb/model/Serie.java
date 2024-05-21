package org.example.hqlmoviesdb.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    String title;
    @Column(name = "release_date")
    LocalDateTime releaseDate;
    @Column(name = "end_date")
    LocalDateTime endDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    Genre genre;
}
