package org.example.testjpahql.repository;


import org.example.testjpahql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("from Episode e join ActorEpisode ae on e.episodeId = ae.episode.episodeId " +
            "join Actor a on a.actorId = ae.actor.actorId " +
            "where a.firstName = :name and a.lastName = :lastName")
    List<Episode> getEpisodeWithActor(String name, String lastName);
}
