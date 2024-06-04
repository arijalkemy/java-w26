package org.responseentity.movies.utils;

import org.responseentity.movies.dto.EpisodeDTO;
import org.responseentity.movies.model.Episode;

public class EpisodeMapper {
    public static EpisodeDTO entityToDto(Episode entity){
        return EpisodeDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .number(entity.getNumber())
                .releaseDate(entity.getReleaseDate())
                .rating(entity.getRating())
                .season(entity.getSeason().getTitle())
                .serie(entity.getSeason().getSerie().getTitle())
                .build();
    }
}
