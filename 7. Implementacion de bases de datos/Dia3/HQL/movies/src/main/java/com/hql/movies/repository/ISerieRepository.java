package com.hql.movies.repository;

import com.hql.movies.model.Episode;
import com.hql.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie, Long> {

    @Query("from Serie s where s.seasons > :seasons")
    List<Serie> findBySeasonsGreaterThan(@Param("seasons") int seasons);

    @Query("select e from Episode e join e.series se join se.actors a where a.id = :actorId")
    List<Episode> findByEpisodesActorId(@Param("actorId") int actorId);
}
