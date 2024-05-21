package com.example.hqlmoviesdb.repository;

import com.example.hqlmoviesdb.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface IMoviesRepository  extends CrudRepository <Actor, Long>{
    @Query("SELECT a.firstName, a.lastName FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<String> findAllActorsWithFavoriteMovie();

    @Query("SELECT a.firstName, a.lastName FROM Actor a WHERE a.rating > :rating")
    List<String> findActorByRatingGreaterThan(@Param("rating") Double rating);

    @Query("SELECT am.actor.firstName, am.actor.lastName FROM ActorMovie am WHERE am.movie.title = :movieTitle")
    List<String> findActorsByMovieTitle(@Param("movieTitle") String movieTitle);

    @Query("SELECT DISTINCT am.movie.title, am.actor.firstName, am.actor.lastName FROM ActorMovie am " +
            "WHERE am.actor.rating > :rating")
    List<String> findMoviesByActorRating(@Param("rating") Double rating);

    @Query("SELECT m.title FROM Movie m WHERE m.genre.name = :genreName")
    List<String> findMoviesByGenreName(@Param("genreName") String genreName);

    @Query ("SELECT s.title FROM Series s WHERE size(s.seasons) > :numberOfSeasons")
    List<String> findSeriesBySeasonsNumber(@Param("numberOfSeasons") int numberOfSeasons);

    @Query ("SELECT e.title FROM Episode e JOIN e.actorEpisodes a " +
            "WHERE a.actor.firstName = :firstName AND a.actor.lastName = :lastName")
    List<String> findEpisodesByActorName(@Param("firstName") String firstName,
                                         @Param("lastName")String lastName);

}
