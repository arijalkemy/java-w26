package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, String>, JpaSpecificationExecutor<Movies> {

    @Query("SELECT mv FROM Movies mv JOIN mv.genreId gr WHERE gr.name = :genre")
    List<Movies> getMoviesByGenre(String genre);
}
