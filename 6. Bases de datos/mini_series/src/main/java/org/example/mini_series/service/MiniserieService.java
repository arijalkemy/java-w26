package org.example.mini_series.service;

import org.example.mini_series.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniserieService {
    private final IMiniserieRepository repository;

    public MiniserieService(IMiniserieRepository repository) {
        this.repository = repository;
    }
}
