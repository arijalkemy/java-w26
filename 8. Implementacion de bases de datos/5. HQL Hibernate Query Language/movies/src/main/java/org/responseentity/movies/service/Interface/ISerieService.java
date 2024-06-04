package org.responseentity.movies.service.Interface;

import org.responseentity.movies.dto.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> listSeriesByNumberOfSeasons(Integer numberOfSeasons);
}
