package com.practica.miniseries.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.practica.miniseries.repository.IMiniserieRepository;

@Service
@RequiredArgsConstructor
public class MiniserieService {

    private final IMiniserieRepository miniserieRepository;

}
