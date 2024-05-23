package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episodes")
public class Episodes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "number")
    private Integer number;
    
    @Column(name = "release_date")
    private LocalDate releaseDate;
    
    @Column(name = "rating")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Seasons season;

}
