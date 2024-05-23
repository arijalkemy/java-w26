package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "genre")
    private Set<Series> series = new LinkedHashSet<>();

// Getters and setters
}