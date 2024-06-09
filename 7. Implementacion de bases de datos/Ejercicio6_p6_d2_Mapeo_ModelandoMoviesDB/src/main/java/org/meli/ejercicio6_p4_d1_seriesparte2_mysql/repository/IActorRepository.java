package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model.projections.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model.Actor, Long> {
    @Query("select a.firstName as firstName, a.lastName as lastName,  f.title as favoriteMovie from Actor a " +
            " inner join a.favoriteMovie f ")
    List<ActorFavoriteMovie> selectactorFavoriteMovie();

    @Query("select a.firstName as firstName, a.lastName as lastName from Actor a " +
            " where a.rating >= :rating")
    List<ProjectionActor> selectActorsByRating(@Param("rating") double rating);

    @Query(" select a.lastName as lastName, a.firstName as firstName from ActorMovie am " +
            " inner join am.actor a " +
            " inner join am.movie m " +
            " where m.title = :tittle ")
    List<ProjectionActor> selectActorsByTitle(@Param("tittle") String tittle);

    @Query(" select m.title as title, m.awards as awards, g.name as genre, a.rating as rating  from ActorMovie am " +
            " inner join am.actor a " +
            " inner join am.movie m " +
            " inner join m.genre g "  +
            " where a.rating >= :rating ")
    List<ProjectionMovie> selectMovieByRating(@Param("rating") double rating);

    @Query( " select e.title as title from ActorEpisode ae " +
            " inner join ae.episode e " +
            " inner join ae.actor a   " +
            " where a.firstName = :firstName")
    List<ProjectionEpisode> listProjectionEpisodesByActor(@Param("firstName") String firstName);

}
