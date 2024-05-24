package com.moviesgenerateschemabonus.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "seasons")
@Data
public class Season {
    @Id
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "title")
    private String title;

    private Integer number;

    @Column(name ="release_date")
    private LocalDateTime releaseDate;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
}
