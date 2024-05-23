package com.crudpractice.movies.repository;

import com.crudpractice.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findActorsByFavoriteMovieNotNull();
    List<Actor> findActorsByRatingGreaterThan(Double number);
    List<Actor> findActorsByMovies_TitleContaining(String title);
}
