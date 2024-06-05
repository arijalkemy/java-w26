package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.EpisodeDTO;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.SerieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository.IActorRepository;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository.ISeriesRepository;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.IActorService;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService implements ISerieService {
    @Autowired
    private ISeriesRepository seriesRepository;
    @Autowired
    private IActorRepository actorRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Transactional
    public List<SerieDto> getAllSeries(Integer id) {
        return seriesRepository.listProjectionSeriesByNumberSeasons(id)
                .stream()
                .map(v -> objectMapper.convertValue(v, SerieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EpisodeDTO> getAllEpisodes(String name) {
        return actorRepository.listProjectionEpisodesByActor(name)
                .stream()
                .map(v -> objectMapper.convertValue(v, EpisodeDTO.class))
                .collect(Collectors.toList());
    }
}
