package com.mercadolibree.HQL_movies_db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Entity(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

}
