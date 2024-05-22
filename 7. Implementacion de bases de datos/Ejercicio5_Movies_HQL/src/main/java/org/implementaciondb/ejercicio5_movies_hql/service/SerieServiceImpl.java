package org.implementaciondb.ejercicio5_movies_hql.service;

import org.implementaciondb.ejercicio5_movies_hql.exception.NoFoundException;
import org.implementaciondb.ejercicio5_movies_hql.mapper.SerieMapper;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.SerieDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Serie;
import org.implementaciondb.ejercicio5_movies_hql.repository.ISerieRepository;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {

    @Autowired
    private ISerieRepository serieRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SerieDto> findSeriesWithMoreSeasonsThan(Integer numberOfSeasons) {
        List<Serie> series = serieRepository.findByMoreSeasonsThan(numberOfSeasons);
        return createListResponse(
                series,
                "No hay series registradas que tengan más de " + numberOfSeasons + " temporadas"
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<SerieDto> getSeriesByGenreAndAverageEpisodeRating(String genreName, Double averageRating) {
        List<Serie> series = serieRepository.findByGenreAndAverageEpisodeRatingGreaterThan(genreName, averageRating);
        return createListResponse(
                series, "No hay series registradas que cumplan con los parametros establecidos"
        );
    }

    private List<SerieDto> createListResponse(List<Serie> series, String errorMessage) {
        if (series.isEmpty()) {
            throw new NoFoundException(errorMessage);
        }
        return series
                .stream()
                .map(SerieMapper::convertToDto)
                .toList();
    }

}
