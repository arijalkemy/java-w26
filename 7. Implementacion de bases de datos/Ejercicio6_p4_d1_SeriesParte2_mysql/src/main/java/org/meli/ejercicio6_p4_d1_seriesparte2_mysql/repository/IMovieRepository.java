package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model.Movie;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model.projections.ProjectionMovie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends CrudRepository<Movie, Long> {
    @Query("  select m.title as title, m.rating as rating, m.awards as awards, g.name as genre from Movie m " +
            " inner join m.genre g" +
            " where g.name = :name ")
    List<ProjectionMovie> findByGenre(@Param("name") String name);
}
