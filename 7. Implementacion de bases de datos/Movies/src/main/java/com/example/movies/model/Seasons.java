package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "seasons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seasons {
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
    
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Series serie;
}
