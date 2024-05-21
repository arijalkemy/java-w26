package com.example.movieshqlasync.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name= "created_at", nullable = true)
    LocalDate createdAt;
    @Column(name= "updated_at", nullable = true)
    LocalDate updatedAt;
    @Column(name= "first_name")
    String firstName;
    @Column(name= "last_name")
    String lastName;
    Double rating;
    @Column(name= "favorite_movie_id")
    Integer favoriteMovie;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private List<ActorMovie> actorMovies;
}
