package org.example.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(length = 500)
    private String title;

    @Column(nullable = false)
    private Integer number;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private Season season;
}

// O

