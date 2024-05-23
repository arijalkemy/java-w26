package com.crudpractice.movies.repository;

import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByActorsInMovie_RatingGreaterThan(Double rating);
    List<Movie> findMovisByGenre_NameContaining(String title);
}
