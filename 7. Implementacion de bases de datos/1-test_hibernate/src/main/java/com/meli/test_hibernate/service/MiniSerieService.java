package com.meli.test_hibernate.service;

import com.meli.test_hibernate.model.MiniSerie;
import com.meli.test_hibernate.repository.IMiniSerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MiniSerieService {

    private final IMiniSerieRepository miniSerieRepository;

    public String addMiniSerie(MiniSerie student){
        miniSerieRepository.save(student);
        return "me guarde";
    }
}
