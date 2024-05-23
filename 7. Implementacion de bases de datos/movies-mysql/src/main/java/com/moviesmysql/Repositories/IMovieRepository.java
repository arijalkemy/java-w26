package com.moviesmysql.Repositories;

import com.moviesmysql.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m " +
            "where not exists (" +
            "    select a from ActorMovie am " +
            "    join am.actor a " +
            "    where am.movie = m and a.rating <= :rating" +
            ")")
    public List<Movie> getMoviesWithActoresWithRatingGreaterThan(Double rating);
    public List<Movie> findByGenreId(Long generoId);
}
