package com.example.movieshqlasync.repository;

import com.example.movieshqlasync.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMovieRepository extends CrudRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m " +
            "INNER JOIN ActorMovie am ON m.id = am.movie.id AND am.actor.rating > :rating")
    List<Movie> findMoviesByActorRating(Double rating);
    List<Movie> findAllByGenreId(int genreId);
}
