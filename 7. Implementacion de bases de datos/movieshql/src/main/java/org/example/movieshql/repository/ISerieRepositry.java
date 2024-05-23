package org.example.movieshql.repository;

import org.example.movieshql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepositry extends CrudRepository<Serie, Integer> {

    @Query("FROM Serie s WHERE SIZE(s.seasons) >= :quantity")
    List<Serie> findSeriesByNumberOfSeasons(@Param("quantity") Double quantity);
}
