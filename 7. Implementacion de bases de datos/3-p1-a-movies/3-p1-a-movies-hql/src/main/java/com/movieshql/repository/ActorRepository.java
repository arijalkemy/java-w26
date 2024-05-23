package com.movieshql.repository;

import com.movieshql.trash.Actor;
import com.movieshql.trash.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    List<Actor> findByFavoriteMovieIsNotNull();

    List<Actor> findByRatingGreaterThan(Double rating);

    @Query("SELECT a FROM Actor a JOIN a.movies m WHERE m.title = :title")
    List<Actor> findByMovieTitle(String title);

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.actors a WHERE a.rating > :rating")
    List<Movie> findMoviesByActorRatingGreaterThan(Double rating);
}
