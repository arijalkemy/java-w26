package com.example.HQL.repository;

import com.example.HQL.model.Genre;
import com.example.HQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByTitle(String title);
    List<Movie> findByGenre(Genre genre);
    @Query("SELECT m FROM ActorMovie am JOIN am.actor a JOIN am.movie m WHERE a.rating >= :rating")
    List<Movie> findAllWithActorsWithRatingAbove(@Param("rating") Double rating);
}
