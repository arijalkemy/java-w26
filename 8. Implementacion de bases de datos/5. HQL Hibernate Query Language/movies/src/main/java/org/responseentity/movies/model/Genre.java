package org.responseentity.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genres", schema = "movies_db", indexes = {
        @Index(name = "genres_ranking_unique", columnList = "ranking", unique = true)
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "ranking")
    private Integer ranking;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "genre")
    private Set<Series> series = new LinkedHashSet<>();

}