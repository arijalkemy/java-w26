package org.responseentity.movies.repository;

import org.responseentity.movies.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {
    @Query("SELECT s FROM Series s WHERE SIZE(s.seasons) > :numberOfSeasons")
    List<Series> listByNumberOfSeasons(@Param("numberOfSeasons") Integer numberOfSeasons);
}