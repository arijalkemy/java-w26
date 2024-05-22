package org.ggomezr.movies.domain.repository;

import org.ggomezr.movies.domain.model.Episode;
import org.ggomezr.movies.domain.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("SELECT DISTINCT e.title FROM Episode e JOIN e.actors a WHERE a.firstName LIKE %:actor%")
    List<String> findAllEpisodesWhereActorIsPresent(String actor);

    @Query("SELECT DISTINCT e.title FROM Episode e WHERE e.rating > :rating")
    List<String> findAllEpisodesWhichRatingIsGreaterThan(Float rating);
}
