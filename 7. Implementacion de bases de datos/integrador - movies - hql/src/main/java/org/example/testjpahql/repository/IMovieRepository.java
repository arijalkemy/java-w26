package org.example.testjpahql.repository;


import org.example.testjpahql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("from Movie m join ActorMovie am on am.movie.movieId = m.movieId " +
            "join Actor a on a.actorId = am.actor.actorId " +
            "where a.rating > :rating")
    List<Movie> getMoviesWithActorRating(BigDecimal rating);

    @Query("from Movie m join Genre g on m.genreMovieId.genreId = g.genreId " +
            "where g.name = :name")
    List<Movie> getMoviesWithGenre(String name);

}
