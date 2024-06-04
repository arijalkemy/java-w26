package org.responseentity.movies.service;

import org.responseentity.movies.dto.SerieDTO;
import org.responseentity.movies.model.Series;
import org.responseentity.movies.repository.SeriesRepository;
import org.responseentity.movies.service.Interface.ISerieService;
import org.responseentity.movies.utils.SeriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {
    SeriesRepository seriesRepository;

    public SerieService(@Autowired SeriesRepository seriesRepository){
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SerieDTO> listSeriesByNumberOfSeasons(Integer numberOfSeasons) {
        List<Series> series = seriesRepository.listByNumberOfSeasons(numberOfSeasons);
        return series.stream()
                .map(serie -> SeriesMapper.entityToDto(serie))
                .collect(Collectors.toList());
    }
}
