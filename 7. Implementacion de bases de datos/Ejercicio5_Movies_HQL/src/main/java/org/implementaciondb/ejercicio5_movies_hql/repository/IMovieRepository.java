package org.implementaciondb.ejercicio5_movies_hql.repository;

import org.implementaciondb.ejercicio5_movies_hql.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m " +
            "FROM Movie m JOIN m.actorMovieList am JOIN am.actor a " +
            "WHERE a.rating > :actorRating"
    )
    List<Movie> findByActorsWithRatingGreaterThan(@Param("actorRating") BigDecimal actorRating);


    @Query("SELECT m " +
            "FROM Movie m JOIN m.genre g " +
            "WHERE g.id = :genreId"
    )
    List<Movie> findMoviesWithGenre(@Param("genreId") Long genreId);


}
