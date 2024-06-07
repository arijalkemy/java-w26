package com.mercadolibree.HQL_movies_db.repository;

import com.mercadolibree.HQL_movies_db.models.Actor;
import org.aspectj.weaver.ast.Literal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findAllByMovieIdIsNotNull();

    @Query("SELECT u FROM actors u WHERE u.rating >= :rating")
    List<Actor> findActorsByCustomAwards(Double rating);

    @Query("SELECT u FROM actors u JOIN movies m ON u.movieId=m.id WHERE m.title=:name")
    List<Actor> findActorsByMovie(String name);
}
