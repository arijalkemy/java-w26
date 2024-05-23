package org.ggomezr.movies.domain.repository;

import org.ggomezr.movies.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT DISTINCT m.title, m.rating FROM Movie m JOIN m.actors a WHERE a.rating > :rating")
    List<String> findAllMoviesWhoseActorsRatingIsGreaterThan(Float rating);

    @Query("SELECT DISTINCT m.title FROM Movie m JOIN m.genre g WHERE g.name LIKE %:genre%")
    List<String> findAllMoviesWithGenre(String genre);
}
