package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface episodeRepository extends CrudRepository<Episode,Long> {
    List<Episode> findAll();

    @Query("SELECT e.number, e.rating, e.title FROM Episode e join e.actorEpisodes ae WHERE ae.actor= :actor")
    List<String> findEpisodesByActor(String actor);
}
