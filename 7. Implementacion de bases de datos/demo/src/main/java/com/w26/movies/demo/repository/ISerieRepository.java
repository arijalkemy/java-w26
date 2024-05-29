package com.w26.movies.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.w26.movies.demo.entity.Serie;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("FROM Serie")
    public List<Serie> findByGreaterThanCountSeasons(Integer countSeason);
}
