package com.mercadolibre.projectname.repository;

import com.mercadolibre.projectname.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends CrudRepository<Movie, Long> {
    @Query("select e from Movie e join e.actors act where act.rating > :rating")
    List<Movie> findMoviesThatHaveActorsWithRatingHigherThan(@Param("rating") Float rating);

    @Query("select e from Movie e where e.genre.id = :genre_id")
    List<Movie> findMoviesByGenre(@Param("genre_id") Long genre_id);
}
