package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface actorRepository extends CrudRepository<Actor,Long> {
    List<Actor> findAll();

    @Query("SELECT a.firstName, a.lastName FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<String> findActorsWithFavoriteMovie();

    @Query("SELECT a.firstName, a.lastName FROM Actor a WHERE a.rating > :rating")
    List<String> findActorsWithRatingGreaterThan(Double rating);

    @Query("SELECT a.firstName, a.lastName FROM Actor a join a.actorMovies am join Movie m " +
            "ON am.movie=m WHERE m.title = :title")
    List<String> findActorsByMovieTitle(String title);

}
