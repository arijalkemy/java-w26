package com.crudpractice.movies.repository;

import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("select e from Episode e join e.actorsInEpisode a where a.firstName like %:name% or a.lastName like %:name%")
    List<Episode> findEpisodesByActors(String name);
}
