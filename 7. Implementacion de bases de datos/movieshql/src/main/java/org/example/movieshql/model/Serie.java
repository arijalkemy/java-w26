package org.example.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable=false)
    private Genre genre;

    @OneToMany(mappedBy = "serie")
    Set<Season> seasons;
}
