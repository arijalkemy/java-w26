package com.mercadolibre.moviesHQL.repository;

import com.mercadolibre.moviesHQL.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie,Integer> {
    @Query("SELECT s, count(g.id) as cant_season " +
            "FROM Serie s " +
            "JOIN Season g ON g.serie_id.id = s.id " +
            "GROUP BY s " +
            "HAVING cant_season > :cant_seasons ")
    List<Serie> findAllByCountSeason(@Param("number") Integer cant_seasons);
}
