package org.implementaciondb.ejercicio5_movies_hql.repository;

import org.implementaciondb.ejercicio5_movies_hql.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a " +
            "FROM Actor a " +
            "WHERE a.favoriteMovie IS NOT NULL"
    )
    List<Actor> findByFavoriteMovieExist();

    @Query("SELECT a " +
            "FROM Actor a " +
            "WHERE a.rating > :rating"
    )
    List<Actor> findByRatingGreaterThan(@Param("rating") BigDecimal rating);

    @Query("SELECT a " +
            "FROM Actor a JOIN a.actorMovieList am " +
            "WHERE am.movie.id = :movieId"
    )
    List<Actor> findByWorkingOnTheMovie(@Param("movieId") Long movieId);

    @Query("SELECT a " +
            "FROM Actor a JOIN a.actorEpisodeList ae JOIN ae.episode e JOIN e.season se JOIN se.serie s " +
            "WHERE a.rating > :rating " +
            "GROUP BY a.id " +
            "HAVING COUNT(s.id) > 1")
    List<Actor> findByMultipleSeriesAndRatingGreaterThan(@Param("rating") BigDecimal rating);

}
