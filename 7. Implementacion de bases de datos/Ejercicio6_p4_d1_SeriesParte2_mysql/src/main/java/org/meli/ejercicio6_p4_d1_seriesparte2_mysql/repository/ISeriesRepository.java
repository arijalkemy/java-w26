package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model.Series;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.model.projections.ProjectionSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends CrudRepository<Series, Long> {
    @Query("SELECT se.title AS title, COUNT(s) AS numberSeasons " +
            "FROM Season s " +
            "INNER JOIN s.series se " +
            "GROUP BY se.title " +
            "HAVING COUNT(s) > :numberSeasons")
    List<ProjectionSerie> listProjectionSeriesByNumberSeasons(@Param("numberSeasons") Integer numberSeasons);

}
