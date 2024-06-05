package org.example.testjpahql.service;


import org.example.testjpahql.entity.dto.MovieDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {

    List<MovieDTO> getMovieWithActorRating(BigDecimal rating);
    List<MovieDTO> getMovieWithGenre(String name);
}
