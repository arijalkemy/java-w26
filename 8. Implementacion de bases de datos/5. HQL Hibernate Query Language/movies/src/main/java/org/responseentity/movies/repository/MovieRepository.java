package org.responseentity.movies.repository;

import jakarta.websocket.server.PathParam;
import org.responseentity.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE upper(m.genre.name) = upper(:genre)")
    List<Movie> listAllMoviesByGenre(@Param("genre") String genre);
}