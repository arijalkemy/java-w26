package com.mercadolibre.moviesHQL.repository;

import com.mercadolibre.moviesHQL.model.entity.Actor;
import com.mercadolibre.moviesHQL.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor,Integer> {
    List<Actor> findAllByFavorite_movie_idIsNotEmpty();

    List<Actor> findAllByRatingGreaterThan(Double rating);

    @Query("SELECT a " +
            "FROM Actor a " +
            "JOIN ActorMovie am ON am.actor_id.id = a.id " +
            "JOIN Movie m ON m.id = am.movie_id.id " +
            "WHERE m.id = :movie ")
    List<Actor> findAllByWorkingInMovie(@Param("number") Integer movie);
}
