package org.example.movieshql.repository;

import org.example.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository <Movie, Long> {

    @Query("SELECT DISTINCT am.movie FROM ActorMovie am WHERE am.actor.rating > :rating")
    List<Movie> listMoviesWithActorsAboveRating(@Param("rating") double rating);

    @Query("SELECT m from Movie as m where m.genre.name = :genre")
    List<Movie> allMoviesByGenre(@Param("genre") String genre);
}
