package com.w26.movies.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w26.movies.demo.entity.Genre;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {
     
}
