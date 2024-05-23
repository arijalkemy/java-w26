package org.example.movieshql.repository;


import org.example.movieshql.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends CrudRepository<Episode, Integer> {

    @Query("SELECT ae.episode FROM ActorEpisode ae  WHERE ae.actor.id = :id" )
    List<Episode> findEpisodesByActorId(@Param("id") Integer id);
}
