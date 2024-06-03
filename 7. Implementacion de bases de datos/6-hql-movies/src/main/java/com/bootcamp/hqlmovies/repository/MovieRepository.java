package com.bootcamp.hqlmovies.repository;

import com.bootcamp.hqlmovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("from Movie m inner join m.actorMovies am inner join am.actor a where a.rating > :ratingValue")
    List<Movie> findMovieWithActorsWithRatingGt(Double ratingValue);

    List<Movie> findAllByGenreName(String genre);
}
