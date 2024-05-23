package com.crudpractice.movies.repository;

import com.crudpractice.movies.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {
}
