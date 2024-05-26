package com.example.HQL.repository;

import com.example.HQL.model.Episode;
import com.example.HQL.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Series, Integer> {
    @Query("FROM Series s WHERE size(s.seasons) > :minSeasons")
    List<Series> findAllWithMoreSeasonsThan(@Param("minSeasons") Integer minSeasons);
    //@Query("SELECT a.episodes FROM Actor a WHERE a.firstName LIKE %:actorName% OR a.lastName LIKE %:actorName%")
    @Query("SELECT a.episodes FROM Actor a WHERE a.firstName = :actorName")
    List<Episode> findAllEpisodesWithActor(@Param("actorName") String actorName);
}
