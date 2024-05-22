package com.implementaciondb.ejercicio12_moviesmodel.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at", columnDefinition = "DATE")
    private LocalDate createdAt;

    @Column(name = "updated_at", columnDefinition = "DATE")
    private LocalDate updatedAt;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @JsonBackReference
    private Movie favoriteMovie;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ActorMovie> actorMovieList;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ActorEpisode> actorEpisodeList;

}
