package com.bootcamp.hqlmovies.repository;

import com.bootcamp.hqlmovies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("from Actor a inner join a.favoriteMovie")
    List<Actor> findAllWithRatingGreaterThan();

    @Query("from Actor a where a.rating > :rating")
    List<Actor> findAllWithRatingGreaterThan(Double rating);

    @Query("from Actor a inner join a.actorMovies am inner join am.movie m where m.title = :movieTitle")
    List<Actor> findAllInMovie(String movieTitle);
}
