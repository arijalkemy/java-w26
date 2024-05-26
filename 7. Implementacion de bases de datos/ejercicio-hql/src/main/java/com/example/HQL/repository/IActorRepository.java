package com.example.HQL.repository;

import com.example.HQL.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
    @Query("FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllActorsThatHaveFavoriteMovie();

    @Query("FROM Actor a WHERE a.rating >= :rating")
    List<Actor> findAllActorsWithRatingAbove(@Param("rating") Integer rating);

    @Query("SELECT am.actor FROM ActorMovie am JOIN am.actor a JOIN am.movie m WHERE m.title = :title")
    List<Actor> findAllWorkingInMovie(@Param("title") String title);
}
