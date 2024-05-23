package org.example.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(length = 500)
    private String title;

    @Column(nullable = false)
    private Integer number;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id", nullable=false)
    private Serie serie;

    @OneToMany(mappedBy="season")
    Set<Episode> episodes;

    // Otras relaciones o métodos si es necesario

    // No incluir getters y setters
}
