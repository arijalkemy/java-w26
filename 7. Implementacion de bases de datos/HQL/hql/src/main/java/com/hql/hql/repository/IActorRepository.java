package com.hql.hql.repository;

import com.hql.hql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Integer> {

    @Query("SELECT u FROM Actor as u WHERE u.rating > :raiting")
    List<Actor> findActorByRatingGreaterhan(@Param("raiting") int raiting );

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findActorByFavoriteMovieNotNull();

    @Query("SELECT a.actor FROM ActorsByMovies a WHERE a.movie.title = :title")
    List<Actor> findActorsByMovieName( @Param("title") String movieTitle );
}
