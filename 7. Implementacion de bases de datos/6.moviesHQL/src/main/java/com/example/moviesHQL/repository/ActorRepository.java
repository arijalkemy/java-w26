package com.example.moviesHQL.repository;

import com.example.moviesHQL.model.Actor;
import com.example.moviesHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findActorsByFavoriteMovie(Movie movie);
    List<Actor> findActorsByRatingGreaterThan(Double rating);
}
