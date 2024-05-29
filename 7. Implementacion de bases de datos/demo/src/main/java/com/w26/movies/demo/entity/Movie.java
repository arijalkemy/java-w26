package com.w26.movies.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    Integer id;

    String title;
    
    @Column(columnDefinition = "decimal unsigned")
    Double rating;

    Integer awards;

    @Column(columnDefinition = "date")
    LocalDateTime release_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    @JsonBackReference
    Genre genero;

    Integer length;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actor_movie", 
    joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id"))
    List<Actor> actor;


    @OneToMany(mappedBy = "favoriteMovie")
    @JsonManagedReference
    List<Actor> actorsFolled;

    LocalDateTime created_at;
    LocalDateTime updated_at;
}