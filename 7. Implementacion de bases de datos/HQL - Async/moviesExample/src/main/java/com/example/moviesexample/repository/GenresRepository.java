package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenresRepository extends JpaRepository<Genres, String>, JpaSpecificationExecutor<Genres> {

}
