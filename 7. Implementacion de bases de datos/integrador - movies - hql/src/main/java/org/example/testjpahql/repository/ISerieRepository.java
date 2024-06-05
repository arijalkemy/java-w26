package org.example.testjpahql.repository;

import org.example.testjpahql.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("select s from Serie s join Season se on s.serieId = se.serie.serieId " +
            "group by s having count(s) > :seasonsNum")
    List<Serie> getSeriesBySeasons(Integer seasonsNum);


}
