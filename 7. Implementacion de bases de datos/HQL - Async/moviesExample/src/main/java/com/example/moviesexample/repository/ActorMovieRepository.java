package com.example.moviesexample.repository;

import com.example.moviesexample.entity.ActorMovie;
import com.example.moviesexample.entity.Actors;
import com.example.moviesexample.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, String>, JpaSpecificationExecutor<ActorMovie> {
    @Query("SELECT ac FROM ActorMovie am JOIN am.actorId ac JOIN am.movieId m WHERE m.title = :movieName")
    List<Actors> findActorsInMovie(String movieName);

    @Query("SELECT m FROM ActorMovie am JOIN am.actorId ac JOIN am.movieId m WHERE ac.rating >= :rating")
    List<Movies> findMoviesByRating(BigDecimal rating);

}
