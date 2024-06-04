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
@Table(name = "seasons", schema = "movies_db")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Size(max = 500)
    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "number", columnDefinition = "int UNSIGNED")
    private Long number;

    @NotNull
    @Column(name = "release_date", nullable = false)
    private Instant releaseDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    private Series serie;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes = new LinkedHashSet<>();

}