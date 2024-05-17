package com.ejerciciosjpa.miniseries.service;

import com.ejerciciosjpa.miniseries.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    @Autowired
    IMiniSerieRepository miniSerieRepository;
}
