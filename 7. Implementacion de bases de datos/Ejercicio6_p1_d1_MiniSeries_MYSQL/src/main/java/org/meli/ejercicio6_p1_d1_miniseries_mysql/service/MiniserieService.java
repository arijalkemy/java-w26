package org.meli.ejercicio6_p1_d1_miniseries_mysql.service;

import org.meli.ejercicio6_p1_d1_miniseries_mysql.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniserieService {
    private IMiniserieRepository miniserieRepository;

    public MiniserieService(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }
}
