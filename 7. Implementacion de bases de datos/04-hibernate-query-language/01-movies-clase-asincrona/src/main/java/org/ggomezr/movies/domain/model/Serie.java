package org.ggomezr.movies.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDate updatedAt;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "release_date")
    private Date releaseDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}
