package org.ggomezr.movies.domain.repository;

import org.ggomezr.movies.domain.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer>{
    @Query("SELECT DISTINCT a.firstName, a.lastName, m.title FROM Actor a JOIN a.movies m WHERE a.favoriteMovieId IS NOT NULL")
    List<String> findAllActorsWithFavoriteMovie();

    @Query("SELECT DISTINCT a.firstName, a.lastName, a.rating FROM Actor a WHERE a.rating > :rating")
    List<String> findAllActorsWithRatingGreaterThan(Float rating);

    @Query("SELECT DISTINCT a.firstName, a.lastName, m.title FROM Actor a JOIN a.movies m WHERE m.title LIKE %:movieTitle%")
    List<String> findAllActorsWhoWorkInTheMovie(String movieTitle);
}
