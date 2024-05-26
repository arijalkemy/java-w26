package com.example.HQL.service;

import com.example.HQL.dto.response.MovieResponseDto;
import com.example.HQL.model.Movie;

import java.util.List;

public interface IMovieService {
    List<MovieResponseDto> searchAllWithActorsWithRatingAbove(Double rating);
    List<MovieResponseDto> searchAllByGenre(String genre);
}
