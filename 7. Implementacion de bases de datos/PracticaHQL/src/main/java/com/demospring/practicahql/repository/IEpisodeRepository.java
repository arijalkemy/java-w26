package com.demospring.practicahql.repository;

import com.demospring.practicahql.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends CrudRepository<Episode, Long> {
    @Query("SELECT e.title FROM Episode e JOIN e.actorEpisodes ae JOIN Actor a ON a = ae.actor WHERE a.firstName = :firstName AND a.lastName = :lastName")
    List<String> findEpisodesByActorName(String firstName, String lastName);
}
