package org.responseentity.movies.repository;

import org.responseentity.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    @Query("SELECT episode from Episode episode " +
            "INNER JOIN episode.actorEpisodes actor_episodes " +
            "INNER JOIN actor_episodes.actor actor " +
            "WHERE upper(actor.firstName) = :firstName AND upper(actor.lastName) = :lastName")
    List<Episode> listAllEpisodesByActor(@Param("firstName") String firstName, @Param("lastName") String lastName);
}