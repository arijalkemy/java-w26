package com.crudpractice.movies.repository;

import com.crudpractice.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {
    List<Serie> findBySeasons_NumberOfSeasonGreaterThan(int number);
}
