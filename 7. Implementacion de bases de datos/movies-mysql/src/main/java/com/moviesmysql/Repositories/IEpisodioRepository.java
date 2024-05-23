package com.moviesmysql.Repositories;

import com.moviesmysql.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEpisodioRepository extends JpaRepository<Episode, Long> {

    @Query(
            "SELECT e from Episode e " + "JOIN ActorEpisode ae on ae.episode.id = e.id " +
                    "WHERE ae.actor.id = :actorId"
    )
    public List<Episode> findAllEpisodesByActorId(Long actorId);
}
