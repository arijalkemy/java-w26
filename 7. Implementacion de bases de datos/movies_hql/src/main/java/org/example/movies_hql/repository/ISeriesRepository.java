package org.example.movies_hql.repository;

import org.example.movies_hql.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeriesRepository extends JpaRepository<Series, Integer> {
}
