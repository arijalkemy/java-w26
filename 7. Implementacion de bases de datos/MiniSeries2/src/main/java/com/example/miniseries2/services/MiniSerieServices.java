package com.example.miniseries2.services;

import com.example.miniseries2.enums.GeneroEnum;
import com.example.miniseries2.model.MiniSerie;
import com.example.miniseries2.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieServices {
    private IMiniSerieRepository miniSerieRepository;

    public MiniSerieServices(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;

        MiniSerie miniSerie = new MiniSerie();
        miniSerie.setName("Breaking Bad");
        miniSerie.setRating(9.5);
        miniSerie.setAmountOfAwards(100);
        miniSerie.setGenre(GeneroEnum.Drama);

        miniSerieRepository.save(miniSerie);
    }

}
