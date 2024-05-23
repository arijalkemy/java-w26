package com.practica.miniseries.service;

import com.practica.miniseries.model.MiniSerie;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.practica.miniseries.repository.IMiniserieRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiniserieServiceImpl implements IMiniserieService {

    private final IMiniserieRepository miniserieRepository;

    @Override
    @Transactional
    public List<MiniSerie> getSeries() {
        List<MiniSerie> seriesList = miniserieRepository.findAll();
        return seriesList;
    }

    @Override
    public void saveSerie(MiniSerie miniSerie) {
        miniserieRepository.save(miniSerie);
    }

    @Override
    public void deleteSerie(long id) {
        miniserieRepository.deleteById(id);
    }

    @Override
    public MiniSerie findSerie(long id) {
        //en caso de expandir la app deberia levantar una excepcion si es null
        MiniSerie serie = miniserieRepository.findById(id).orElse(null);
        return serie;
    }
}
