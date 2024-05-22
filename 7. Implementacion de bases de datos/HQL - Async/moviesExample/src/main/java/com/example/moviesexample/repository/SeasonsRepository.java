package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeasonsRepository extends JpaRepository<Seasons, String>, JpaSpecificationExecutor<Seasons> {

}
