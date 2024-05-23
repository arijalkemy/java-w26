package com.movieshql.repository;

import com.movieshql.trash.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    List<Episode> findByActorName(String firstName, String lastName);
}
