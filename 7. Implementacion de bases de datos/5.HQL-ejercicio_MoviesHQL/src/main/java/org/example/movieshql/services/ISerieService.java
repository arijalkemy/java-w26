package org.example.movieshql.services;

import org.example.movieshql.DTO.SerieResponseDto;

import java.util.List;

public interface ISerieService {
    List<SerieResponseDto> listSeriesWithMoreThanNTemp(Integer num_temp);
    List<SerieResponseDto> listAllEpisodesByActorName(String name_actor);
}
