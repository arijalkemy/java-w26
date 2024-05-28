package org.example.movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "genres", schema = "movies_db")
@Data
@EqualsAndHashCode
public class GenresEntity {
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
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "ranking")
    private Integer ranking;
    @Basic
    @Column(name = "active")
    private Boolean active;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre", cascade = CascadeType.ALL)
    private List<MoviesEntity> moviesList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre", cascade = CascadeType.ALL)
    private List<SeriesEntity> seriesList;
}
