package com.mercadolibre.projectname.repository;

import com.mercadolibre.projectname.model.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends CrudRepository<Series, Long> {
    @Query("select e from Series e where e.seasons.size > :amount")
    List<Series> findSeriesThatHaveMoreSeasonsThan(@Param("amount") Integer amount);
}
