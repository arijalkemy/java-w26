package com.hql.movies.repository;

import com.hql.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m join m.actors a where a.rating > :actorRating")
    List<Movie> findByActorsRatingGreaterThan(@Param("actorRating") double actorRating);

    @Query("from Movie m where m.genreId = :genreId")
    List<Movie> findByGenreId(@Param("genreId") Integer genreId);
}
