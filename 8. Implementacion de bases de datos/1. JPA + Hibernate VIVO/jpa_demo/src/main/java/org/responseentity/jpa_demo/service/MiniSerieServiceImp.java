package org.responseentity.jpa_demo.service;

import org.responseentity.jpa_demo.model.MiniSerie;
import org.responseentity.jpa_demo.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieServiceImp implements IMiniSerieService{

    @Autowired
    IMiniSerieRepository miniSerieRepository;

    @Override
    public MiniSerie getMiniSerieById(Integer id) {
        return null;
    }
}
