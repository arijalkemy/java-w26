package org.example.integradorminiseries.service;

import org.example.integradorminiseries.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {

    private IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository){
        this.miniSerieRepository = miniSerieRepository;
    };
}
