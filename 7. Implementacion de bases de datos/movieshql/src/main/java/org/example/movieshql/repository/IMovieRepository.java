package org.example.movieshql.repository;

import org.example.movieshql.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends CrudRepository<Movie, Integer> {
    @Query("SELECT DISTINCT m FROM Movie m INNER JOIN m.actors a WHERE a.rating > :rating")
    List<Movie> findMoviesByActorsRatingGreaterThan(@Param("rating") Double rating);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.genre.name) LIKE LOWER(CONCAT('%', :genre, '%'))")
    List<Movie> findByGenreName(@Param("genre") String genre);
}
