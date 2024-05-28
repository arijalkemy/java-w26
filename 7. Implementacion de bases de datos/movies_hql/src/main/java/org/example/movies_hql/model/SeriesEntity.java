package org.example.movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "series", schema = "movies_db")
@Data
@EqualsAndHashCode
public class SeriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Basic
    @Column(name = "end_date")
    private Timestamp endDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private GenresEntity genre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "series", cascade = CascadeType.ALL)
    private List<SeasonsEntity> seasonsList;
}
