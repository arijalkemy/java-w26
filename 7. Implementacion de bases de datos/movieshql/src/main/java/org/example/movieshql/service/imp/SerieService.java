package org.example.movieshql.service.imp;

import org.example.movieshql.dto.SerieDTO;
import org.example.movieshql.model.Serie;
import org.example.movieshql.repository.ISerieRepositry;
import org.example.movieshql.service.ISerieService;
import org.example.movieshql.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {
    @Autowired
    ISerieRepositry serieRepository;

    @Override
    public List<SerieDTO> getSerieByNumberOfSeasonsGratherThan(Double quantity) {
        List<Serie> series = serieRepository.findSeriesByNumberOfSeasons(quantity);
        return ModelMapperUtil.entitiesListToDTOs(series, SerieDTO.class);
    }
}
