package com.bootcamp.hqlmovies.repository;

import com.bootcamp.hqlmovies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
//    @Query("from Actor as a inner join a.favoriteMovie as favoriteMovie")
    @Query("from Actor as a")
    List<Actor> findAllWithAFavoriteMovie();
}
