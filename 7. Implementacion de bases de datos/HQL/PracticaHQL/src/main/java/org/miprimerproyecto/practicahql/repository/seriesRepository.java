package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface seriesRepository extends CrudRepository<Series,Long> {
    List<Series> findAll();

    @Query("SELECT s.title, s.releaseDate, s.endDate FROM Series s join s.seasons se WHERE SIZE (s.seasons) > :seasons")
    List<String> findSeriesWithSeasonsGreaterThan(int seasons);
}
