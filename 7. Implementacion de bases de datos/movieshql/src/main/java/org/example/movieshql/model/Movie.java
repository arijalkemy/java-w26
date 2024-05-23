package org.example.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(length = 10)
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable=false)
    private Genre genre;

    @OneToMany(mappedBy="movie")
    Set<Actor> actors;

    // Otras relaciones o métodos si es necesario

    // No incluir getters y setters
}

