package org.ggomezr.movies.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDate updatedAt;

    private String title;

    @Column(name = "rating")
    private BigDecimal rating;

    private Integer awards;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "release_date")
    private Date releaseDate;

    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
}
