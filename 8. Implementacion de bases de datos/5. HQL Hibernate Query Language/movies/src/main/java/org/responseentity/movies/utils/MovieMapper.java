package org.responseentity.movies.utils;

import org.responseentity.movies.dto.MovieDTO;
import org.responseentity.movies.model.Movie;

public class MovieMapper {
    public static MovieDTO entityToDto(Movie entity){
        String genre = (entity.getGenre() != null) ? entity.getGenre().getName() : "sin genero";

        return MovieDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .rating(entity.getRating())
                .awards(entity.getAwards())
                .releaseDate(entity.getReleaseDate())
                .length(entity.getLength())
                .genre(genre)
                .build();
    }
}
