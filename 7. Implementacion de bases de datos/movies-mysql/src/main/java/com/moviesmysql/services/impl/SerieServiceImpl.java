package com.moviesmysql.services.impl;

import com.moviesmysql.DTOs.SerieDTO;
import com.moviesmysql.Repositories.ISerieRepository;
import com.moviesmysql.models.Serie;
import com.moviesmysql.services.ISerieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {

    private final ISerieRepository serieRepository;

    public SerieServiceImpl(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> getSeriesByTemporadasGreaterThan(Integer cantTemporadas) {
        return this.mapListSerieToSerieDTO(this.serieRepository.findByTemporadasGreaterThan(cantTemporadas));
    }

    private List<SerieDTO> mapListSerieToSerieDTO(List<Serie> series) {
        return series
                .stream()
                .map(serie -> new SerieDTO(
                        serie.getId(),
                        serie.getCreatedAt(),
                        serie.getUpdatedAt(),
                        serie.getTitle(),
                        serie.getReleaseDate(),
                        serie.getEndDate(),
                        serie.getGenre() != null ? serie.getGenre().getId() : null
                ))
                .toList();
    }
}
