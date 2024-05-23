package com.example.movies.repository;

import com.example.movies.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actors, Integer> {
    List<Actors> findAllByFavoriteMovieIsNotNull();
    List<Actors> findActorsByRatingAfter(Double rating);

    @Query("select a from Actors a inner join ActorMovie am on a.id = am.actor.id where am.movie.title like :movie")
    List<Actors> findActorByMovieQuery(@Param("movie") String movie);
}
