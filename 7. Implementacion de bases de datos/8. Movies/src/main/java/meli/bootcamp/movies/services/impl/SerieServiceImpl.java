package meli.bootcamp.movies.services.impl;

import meli.bootcamp.movies.DTOs.SerieDTO;
import meli.bootcamp.movies.Repositories.ISerieRepository;
import meli.bootcamp.movies.models.Serie;
import meli.bootcamp.movies.services.ISerieService;
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
