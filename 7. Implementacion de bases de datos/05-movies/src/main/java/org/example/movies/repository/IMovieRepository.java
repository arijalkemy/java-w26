package org.example.movies.repository;

import org.example.movies.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movie, Long> {
}
