package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.ActorEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface actorEpisodeRepository extends CrudRepository<ActorEpisode,Long> {
    List<ActorEpisode>findAll();
}
