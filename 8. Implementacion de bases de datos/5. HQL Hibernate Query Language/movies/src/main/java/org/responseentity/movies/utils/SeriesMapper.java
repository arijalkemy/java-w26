package org.responseentity.movies.utils;

import org.responseentity.movies.dto.SerieDTO;
import org.responseentity.movies.model.Series;

public class SeriesMapper {
    public static SerieDTO entityToDto(Series entity){
        String genre = (entity.getGenre() != null) ? entity.getGenre().getName() : "sin genero";

        return SerieDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseDate(entity.getReleaseDate())
                .endDate(entity.getEndDate())
                .genre(genre)
                .numberOfSeasons(entity.getSeasons().size())
                .build();
    }
}
