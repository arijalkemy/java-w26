package com.example.MiniSeries.Service;

import com.example.MiniSeries.Repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final IMiniSerieRepository iMiniSerieRepository;

    public MiniSerieService(IMiniSerieRepository iMiniSerieRepository) {
        this.iMiniSerieRepository = iMiniSerieRepository;
    }
}
