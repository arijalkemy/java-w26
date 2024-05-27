package org.example.testjpahql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer seasonId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;

    @OneToMany(mappedBy = "season")
    List<Episode> episodes;

}
