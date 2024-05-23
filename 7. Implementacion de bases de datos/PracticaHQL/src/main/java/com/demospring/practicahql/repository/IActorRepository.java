package com.demospring.practicahql.repository;

import com.demospring.practicahql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Long> {
    @Query("SELECT a.firstName, a.lastName FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<String> findActorsWithOneFavoriteMovie();

    @Query("SELECT a.firstName, a.lastName, a.rating FROM Actor a WHERE a.rating > :rating")
    List<String> findActorsByRatingOver(double rating);

    @Query("SELECT a.firstName, a.lastName FROM Actor a JOIN a.actorMovies am JOIN Movie m ON m = am.movie WHERE m.title = :title")
    List<String> findActorsByMovieName(String title);
}
