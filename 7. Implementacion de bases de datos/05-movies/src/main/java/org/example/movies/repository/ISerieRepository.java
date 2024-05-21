package org.example.movies.repository;

import org.example.movies.model.Serie;
import org.springframework.data.repository.CrudRepository;

public interface ISerieRepository extends CrudRepository<Serie, Long> {
}
