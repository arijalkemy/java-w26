package com.mercadolibre.projectname.repository;

import com.mercadolibre.projectname.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodesRepository extends CrudRepository<Episode, Long> {
    @Query("select e from Episode e join e.actors act where act.id = :actor_id")
    List<Episode> findEpisodesByActorsActing(@Param("actor_id") Long actor_id);
}
