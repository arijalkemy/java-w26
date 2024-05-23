package org.example.miniseries.service;

import org.example.miniseries.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService implements IMiniSerieService {

    @Autowired
    private IMiniSerieRepository miniSerieRepository;
}
