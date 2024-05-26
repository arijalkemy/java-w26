package com.example.HQL.repository;

import com.example.HQL.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByName(String name);
}
