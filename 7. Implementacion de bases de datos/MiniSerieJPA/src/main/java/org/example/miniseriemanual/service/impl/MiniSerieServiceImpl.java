package org.example.miniseriemanual.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.miniseriemanual.dto.MiniSerieDto;
import org.example.miniseriemanual.model.MiniSerie;
import org.example.miniseriemanual.repository.IMiniSerieRepository;
import org.example.miniseriemanual.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieServiceImpl implements IMiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieServiceImpl(@Autowired IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }

    @Override
    public MiniSerie save(MiniSerieDto miniSerie) {
        ObjectMapper objectMapper = new ObjectMapper();
        return miniSerieRepository.save(
                objectMapper.convertValue(miniSerie, MiniSerie.class)
        );
    }
}
