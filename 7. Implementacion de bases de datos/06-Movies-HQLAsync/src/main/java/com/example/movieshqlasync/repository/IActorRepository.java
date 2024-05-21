package com.example.movieshqlasync.repository;

import com.example.movieshqlasync.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Integer> {
    Actor findActorById(@Param("id") Integer id);
    List<Actor> findAllByFavoriteMovieIsNotNull();
    List<Actor> findAllByRatingGreaterThanEqual(Double rating);

    @Query("SELECT a FROM Actor a JOIN a.actorMovies am WHERE am.movieId = :movieId")
    List<Actor> findAllByMovieId(@Param("movieId") Integer movieId);
}
