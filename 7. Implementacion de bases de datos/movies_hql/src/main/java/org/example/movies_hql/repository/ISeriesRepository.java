package org.example.movies_hql.repository;

import org.example.movies_hql.model.SeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeriesRepository extends JpaRepository<SeriesEntity, Integer> {
}
