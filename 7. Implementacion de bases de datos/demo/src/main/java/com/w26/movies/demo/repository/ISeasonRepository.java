package com.w26.movies.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.w26.movies.demo.entity.Season;
import com.w26.movies.demo.entity.Serie;

public interface ISeasonRepository extends JpaRepository<Season, Integer> {

    @Query("select s.serie from Season s group by s.serie.id having count(s.serie.id) > :countSeason")
    List<Serie> findByGreaterThanCountSeasons(Integer countSeason);

}
