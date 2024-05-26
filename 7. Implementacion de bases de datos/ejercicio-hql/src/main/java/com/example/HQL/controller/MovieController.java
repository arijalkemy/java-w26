package com.example.HQL.controller;

import com.example.HQL.dto.response.MovieResponseDto;
import com.example.HQL.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final IMovieService movieService;

    @GetMapping("/actors/have-rating-above")
    public ResponseEntity<List<MovieResponseDto>> getAllWithActorsWithRatingAbove(
        @RequestParam(required = true, name = "rating") Double rating
    ) {
        return new ResponseEntity<>(
            movieService.searchAllWithActorsWithRatingAbove(rating),
            HttpStatus.OK
        );
    }

    @GetMapping("/genre/{genreName}")
    public ResponseEntity<?> getAllByGenre(
        @PathVariable String genreName
    ) {
        return new ResponseEntity<>(
            movieService.searchAllByGenre(genreName),
            HttpStatus.OK
        );
    }
}
