package org.implementaciondb.ejercicio5_movies_hql.mapper;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.GenreDto;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.MovieDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Movie;

public class MovieMapper {

    public static MovieDto convertToDto(Movie movie) {
        GenreDto genreDto;
        if (movie.getGenre() == null) {
            genreDto = null;
        } else {
            genreDto = GenreDto.builder()
                    .id(movie.getGenre().getId())
                    .name(movie.getGenre().getName())
                    .ranking(movie.getGenre().getRanking())
                    .active(movie.getGenre().isActive())
                    .build();
        }
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .rating(movie.getRating())
                .awards(movie.getAwards())
                .releaseDate(movie.getReleaseDate())
                .length(movie.getLength())
                .genre(genreDto)
                .build();
    }

}
