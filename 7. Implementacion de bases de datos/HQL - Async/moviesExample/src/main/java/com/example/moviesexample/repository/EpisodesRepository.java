package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EpisodesRepository extends JpaRepository<Episodes, String>, JpaSpecificationExecutor<Episodes> {

}
