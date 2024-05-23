package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "rating")
    private Double rating;
    
    @Column(name = "awards")
    private Integer awards;
    
    @Column(name = "release_date")
    private LocalDate releaseDate;
    
    @Column(name = "length")
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genres genre;

}
