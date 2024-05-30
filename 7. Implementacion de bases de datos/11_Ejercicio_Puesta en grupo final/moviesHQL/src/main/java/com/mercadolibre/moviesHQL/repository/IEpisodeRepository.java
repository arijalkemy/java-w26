package com.mercadolibre.moviesHQL.repository;

import com.mercadolibre.moviesHQL.model.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query("SELECT a " +
            "FROM Episode a " +
            "JOIN ActorEpisode am ON am.episode_id.id = a.id " +
            "JOIN Actor m ON m.id = am.actor_id.id " +
            "WHERE m.id = :movie ")
    List<Episode> findAllByWorkingActorEquals(@Param("number") Integer actor);
}
