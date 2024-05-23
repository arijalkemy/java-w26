package org.example.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer ranking;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy="genre")
    Set<Movie> movies;

    @OneToMany(mappedBy="genre")
    Set<Serie> series;

    // Otras relaciones o métodos si es necesario

    // No incluir getters y setters
}

