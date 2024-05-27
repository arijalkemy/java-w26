package org.example.movieshql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "rating", nullable = false, precision = 3, scale = 1)
    private BigDecimal rating;

    @ColumnDefault("0")
    @Column(name = "awards", columnDefinition = "int UNSIGNED not null")
    private Long awards;

    @Column(name = "release_date", nullable = false)
    private Instant releaseDate;

    @Column(name = "length", columnDefinition = "int UNSIGNED")
    private Long length;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

}