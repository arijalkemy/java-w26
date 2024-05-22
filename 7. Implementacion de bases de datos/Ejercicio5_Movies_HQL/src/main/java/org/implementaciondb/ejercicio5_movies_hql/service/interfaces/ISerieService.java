package org.implementaciondb.ejercicio5_movies_hql.service.interfaces;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.SerieDto;

import java.util.List;

public interface ISerieService {

    List<SerieDto> findSeriesWithMoreSeasonsThan(Integer numberOfSeasons);

    List<SerieDto> getSeriesByGenreAndAverageEpisodeRating(String genreName, Double averageRating);
}
