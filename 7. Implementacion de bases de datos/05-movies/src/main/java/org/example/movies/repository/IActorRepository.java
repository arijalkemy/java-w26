package org.example.movies.repository;

import org.example.movies.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Long> {

    @Query("select a from Actor a where a.favoriteMovie.id > 0")
    List<Actor> findActorsByFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findActorsByRatingGreaterThan(@Param("rating") Double rating);

    @Query(" select distinct am.actor from ActorMovie am where am.movie.title like :movie")
    List<Actor> findActorsByMovie(@Param("movie") String movie);

}
