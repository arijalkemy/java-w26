package com.mercadolibree.HQL_movies_db.repository;

import com.mercadolibree.HQL_movies_db.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM movies m WHERE m.rating >= :rating")
    List<Movie> getMoviesByRating(Double rating);

    @Query("SELECT m FROM movies m JOIN genres g ON m.genreId=g.id WHERE g.id = (SELECT g.id FROM genres g WHERE g.name = :genre)")
    List<Movie> getMoviesByGenre(String genre);
}
