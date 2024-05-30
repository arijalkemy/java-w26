package com.mercadolibre.moviesHQL.repository;

import com.mercadolibre.moviesHQL.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT m " +
            "FROM Movie m " +
            "JOIN ActorMovie am ON am.movie_id.id = m.id " +
            "JOIN Actor a ON a.id = am.actor_id.id " +
            "WHERE a.rating > :rating ")
    List<Movie> findAllByActorsRatingGreaterThan(@Param("number") Double rating);

    @Query("SELECT m " +
            "FROM Movie m " +
            "JOIN Genres g ON g.id = m.genre_id.id " +
            "WHERE g.id = :genres ")
    List<Movie> findAllByGenresEquals(@Param("number") Integer genres);
}
