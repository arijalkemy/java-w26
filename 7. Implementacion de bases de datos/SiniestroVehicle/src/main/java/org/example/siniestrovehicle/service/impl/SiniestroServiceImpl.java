package org.example.siniestrovehicle.service.impl;

import org.example.siniestrovehicle.repository.ISiniestroRepository;
import org.example.siniestrovehicle.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class SiniestroServiceImpl implements ISiniestroService {

    @Autowired
    private ISiniestroRepository siniestroRepository;

    @Override
    public List<HashMap<String, Object>> getSiniestroMoreThat10000() {
        return siniestroRepository.findSiniestroMoreThat10000();
    }

    @Override
    public List<HashMap<String, Object>> getSiniestroPerdidaMoreThat10000() {
        return siniestroRepository.findSiniestroPerdidaMoreThat10000();
    }
}
