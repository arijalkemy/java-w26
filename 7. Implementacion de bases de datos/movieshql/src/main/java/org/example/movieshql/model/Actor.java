package org.example.movieshql.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(precision = 3)
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie movie;

    // Otras relaciones o métodos si es necesario

    // No incluir getters y setters
}

