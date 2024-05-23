package com.demospring.practicahql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genres", schema = "movies_db", uniqueConstraints = {
        @UniqueConstraint(name = "genres_ranking_unique", columnNames = {"ranking"})
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "ranking", columnDefinition = "int UNSIGNED not null")
    private Long ranking;

    @ColumnDefault("1")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "genre")
    private Set<Serie> series = new LinkedHashSet<>();

}