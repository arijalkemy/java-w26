package org.example.movieshql.repository;

import org.example.movieshql.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Series,Long> {
    @Query("SELECT s FROM Series s WHERE (SELECT COUNT(se) FROM Season se WHERE se.serie = s) > :cantidad_minima")
    List<Series> listSeriesWithMoreThanNTemp(@Param("cantidad_minima") Integer cantidad_minima);

    @Query("SELECT ae FROM ActorEpisode ae WHERE ae.actor.firstName = :actor_name")
    List<Series> listAllEpisodesByActorName(@Param("actor_name") String actor_name);
}
