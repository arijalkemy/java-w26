package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Actors;
import com.example.moviesexample.entity.Movies;
import com.example.moviesexample.entity.dto.ActorsWithFavMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorsRepository extends JpaRepository<Actors, String> {

    @Query("SELECT a.firstName FROM Actors a " +
            "WHERE a.favoriteMovieId IS NOT NULL"
    )
    List<String> findActorsByFavoriteMovie();

    List<Actors> findActorsByRatingGreaterThan(Long rating);
   // List<?> findActorsByFavoriteMovieIdGreaterThan(String first_name);


}
