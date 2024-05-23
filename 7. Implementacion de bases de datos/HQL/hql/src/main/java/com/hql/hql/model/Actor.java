package com.hql.hql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table( name = "actors")
@Getter @Setter
public class Actor {
    @Id
    @GeneratedValue
    @Column( name = "id")
    private int id;
    @Column( name = "created_at")
    private LocalDateTime createdAt;
    @Column( name = "updated_at")
    private LocalDateTime updatedAt;
    @Column( name = "first_name")
    private String firstName;
    @Column( name = "last_name")
    private String lastName;
    private float rating;
    @ManyToOne
    @JoinColumn( name= "favorite_movie_id")
    private Movie favoriteMovie;
}
