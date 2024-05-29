package com.w26.movies.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.w26.movies.demo.entity.ActorEpisode;
import com.w26.movies.demo.entity.Episode;

@Repository
public interface IActorEpisodeRepository extends JpaRepository<ActorEpisode, Integer>{
    
    @Query("select AE.episode from ActorEpisode as AE where AE.actor.id = :idActor")
    List<Episode> findByActorId(Integer idActor);
}
