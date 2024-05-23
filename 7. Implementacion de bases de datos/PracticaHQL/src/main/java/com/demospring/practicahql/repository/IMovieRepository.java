package com.demospring.practicahql.repository;

import com.demospring.practicahql.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends CrudRepository<Movie, Long> {
    @Query("SELECT DISTINCT m.title FROM Movie m JOIN m.actorMovies am JOIN Actor a ON a = am.actor WHERE a.rating > :rating")
    List<String> findMoviesByActorRatingOver(double rating);

    @Query("SELECT DISTINCT m.title FROM Movie m JOIN m.genre g WHERE g.name = :genre")
    List<String> findMoviesByGenre(String genre);
}
