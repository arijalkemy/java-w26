package org.example.testjpahql.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.testjpahql.entity.Serie;
import org.example.testjpahql.entity.dto.SerieDTO;
import org.example.testjpahql.repository.ISerieRepository;
import org.example.testjpahql.service.ISerieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService implements ISerieService {

    private final ISerieRepository serieRepository;
    private final ObjectMapper objectMapper;

    private SerieDTO mapToEntity(Serie serie){
        return objectMapper.convertValue(serie, SerieDTO.class);
    }

    @Override
    public List<SerieDTO> getSerieWithSeasons(Integer seasonsNum) {
        return serieRepository.getSeriesBySeasons(seasonsNum).stream().map(this::mapToEntity).toList();
    }
}
