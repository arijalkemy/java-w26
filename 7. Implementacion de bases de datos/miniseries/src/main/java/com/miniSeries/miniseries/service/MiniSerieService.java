package com.miniSeries.miniseries.service;

import org.springframework.stereotype.Service;
import com.miniSeries.miniseries.repository.MiniSerieRepository;

@Service
public class MiniSerieService {
    private final MiniSerieRepository miniSerieRepository;

    public MiniSerieService(MiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
