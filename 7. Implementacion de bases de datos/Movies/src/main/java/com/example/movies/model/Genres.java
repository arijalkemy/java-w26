package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genres {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "ranking")
    private Double ranking;
    
    @Column(name = "active")
    private Boolean active;

}
