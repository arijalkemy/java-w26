package com.hql.movies.repository;

import com.hql.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("from Actor")
    List<Actor> findByFavoriteMovieIsNotNull();

    @Query("from Actor a where a.rating > :rating")
    List<Actor> findByRatingGreaterThan(@Param("rating") double rating);

    @Query("select a from Actor a join a.movies m where m.id = :id")
    List<Actor> findByMoviesId(@Param("id") Integer id);
}
