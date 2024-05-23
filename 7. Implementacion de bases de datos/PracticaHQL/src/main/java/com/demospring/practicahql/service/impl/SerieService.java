package com.demospring.practicahql.service.impl;

import com.demospring.practicahql.repository.ISerieRepository;
import com.demospring.practicahql.service.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SerieService implements ISerieService {
    private final ISerieRepository serieRepository;

    @Override
    public List<String> findSerieByCantSeasonsOver(int cantSeasons) {
        return serieRepository.findSerieByCantSeasonsOver(cantSeasons);
    }
}
