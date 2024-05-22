package com.hql.movies.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int season;
    private int episodeNumber;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Serie series;
}
