package org.example.movieshql.repository;

import org.example.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("select a from Actor as a where a.favoriteMovie is not null")
    List<Actor> allActorsWithFavoriteMovie();

    @Query("SELECT a from Actor  as a where a.rating >= :rating")
    List<Actor> listActorsWithRatingAbove(@Param("rating") double rating);

    @Query("SELECT ae.actor from ActorMovie as ae where ae.movie.title like :movie")
    List<Actor> allActorsByMovie(@Param("movie") String movie);
}
