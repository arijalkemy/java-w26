package org.example.testjpahql.repository;

import org.example.testjpahql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAllByFavouriteMovieIdNotNull();

    List<Actor> findAllByRatingGreaterThan(BigDecimal decimal);

    @Query("select a from Actor a " +
            "join ActorMovie am on a.actorId = am.actor.actorId " +
            "join Movie m on am.movie.movieId = m.movieId " +
            "where m.title = :title")
    List<Actor> findActorsInMovie(String title);
}
