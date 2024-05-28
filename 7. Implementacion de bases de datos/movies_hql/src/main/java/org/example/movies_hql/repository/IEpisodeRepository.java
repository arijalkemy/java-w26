package org.example.movies_hql.repository;

import org.example.movies_hql.model.EpisodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEpisodeRepository extends JpaRepository<EpisodesEntity, Integer> {
}
