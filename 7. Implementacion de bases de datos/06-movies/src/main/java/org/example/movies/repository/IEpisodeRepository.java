package org.example.movies.repository;

import org.example.movies.model.Episode;
import org.springframework.data.repository.CrudRepository;

public interface IEpisodeRepository extends CrudRepository<Episode, Long> {
}
