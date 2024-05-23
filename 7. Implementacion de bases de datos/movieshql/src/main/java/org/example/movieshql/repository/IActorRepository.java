package org.example.movieshql.repository;

import org.example.movieshql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Long> {
    @Query("FROM Actor a WHERE a.movie IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorsWithHigherRating(@Param("rating") Double rating);

    @Query("SELECT am.actor FROM ActorMovie am WHERE LOWER(am.movie.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Actor> findActorsByMovieNameContains(@Param("title") String title);
}
