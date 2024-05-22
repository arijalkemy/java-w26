package org.implementaciondb.ejercicio5_movies_hql.repository;

import org.implementaciondb.ejercicio5_movies_hql.model.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Long> {

    @Query("SELECT e " +
            "FROM Episode e JOIN e.actorEpisodeList ae " +
            "WHERE ae.actor.id = :actorId"
    )
    List<Episode> findByActor(@Param("actorId") Long actorId);

    @Query("SELECT e " +
            "FROM Episode e JOIN e.actorEpisodeList ae JOIN e.season se " +
            "WHERE se.serie.id = :serieId AND ae.actor.id = :actorId"
    )
    List<Episode> findBySerieAndActor(@Param("serieId") Long serieId, @Param("actorId") Long actorId);

}
