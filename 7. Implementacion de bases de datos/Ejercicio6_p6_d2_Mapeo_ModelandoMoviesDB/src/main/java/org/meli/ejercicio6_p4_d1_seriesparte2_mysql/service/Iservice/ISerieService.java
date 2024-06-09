package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.EpisodeDTO;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> getAllSeries(Integer id);
    List<EpisodeDTO> getAllEpisodes(String name);
}
