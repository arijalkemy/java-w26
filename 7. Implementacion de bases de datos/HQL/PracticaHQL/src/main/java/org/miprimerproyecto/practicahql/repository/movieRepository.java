package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface movieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();

    @Query("SELECT m.title, m.releaseDate, m.rating, m.length, m.awards FROM Movie m join ActorMovie am WHERE am.actor.rating > :rating")
    List<String> findMoviesWithActorsRatingGreaterThan(Double rating);

    @Query("SELECT m.title, m.releaseDate, m.rating, m.length, m.awards FROM Movie m join Genre g ON m.genre=g WHERE m.genre.name = :genre")
    List<String> findMoviesByGenre(String genre);


}
