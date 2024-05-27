package org.example.testjpahql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer serieId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreSerieId;

    @OneToMany(mappedBy = "serie")
    List<Season> seasons;


}
