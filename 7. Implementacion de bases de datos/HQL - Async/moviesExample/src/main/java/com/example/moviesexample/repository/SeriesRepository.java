package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeriesRepository extends JpaRepository<Series, String>, JpaSpecificationExecutor<Series> {

}
