package org.implementaciondb.ejercicio5_movies_hql.mapper;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.SerieDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Serie;

public class SerieMapper {

    public static SerieDto convertToDto(Serie serie) {
        return SerieDto.builder()
                .id(serie.getId())
                .title(serie.getTitle())
                .releaseDate(serie.getReleaseDate())
                .endDate(serie.getEndDate())
                .build();
    }

}
