package org.implementaciondb.ejercicio5_movies_hql.mapper;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.EpisodeDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Episode;

public class EpisodeMapper {

    public static EpisodeDto convertToDto(Episode episode) {
        return EpisodeDto.builder()
                .id(episode.getId())
                .title(episode.getTitle())
                .number(episode.getNumber())
                .releaseDate(episode.getReleaseDate())
                .rating(episode.getRating())
                .build();
    }

}
