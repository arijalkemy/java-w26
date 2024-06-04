package org.responseentity.movies.repository;

import org.responseentity.movies.model.Actor;
import org.responseentity.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllActorsWithFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findAllActorsWithRating(@Param("rating") Long rating);

    @Query("SELECT a FROM Actor a JOIN a.actorMovies am WHERE upper(am.movie.title) = upper(:title)")
    List<Actor> findAllActorsByMovie(@Param("title") String title);

    @Query("SELECT am.movie FROM Actor a JOIN a.actorMovies am WHERE a.rating > :rating")
    List<Movie> findMoviesByActorsRating(@Param("rating") Long rating);

}