package com.mercadolibre.projectname.repository;

import com.mercadolibre.projectname.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorsRepository extends CrudRepository<Actor, Long> {
    @Query("select e from Actor e where e.favoriteMovie != null")
    List<Actor> findActorIfHasFavoriteMovie();

    @Query("select e from Actor e where e.rating > :rating")
    List<Actor> findActorsWithGreaterRatingThan(@Param("rating") Float rating);

    @Query("select e from Actor e join e.moviesActed mov where mov.id = :movie_id") //Consultar
    List<Actor> findActorsThatWorkedInMovie(@Param("movie_id") Long movie_id);
}
