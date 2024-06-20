package com.example.deportista.service.impl;


import com.example.deportista.entities.Deporte;
import com.example.deportista.repository.IDeporteRepository;
import com.example.deportista.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {

    @Autowired
    IDeporteRepository iDeporteRepository;

    @Override
    public List<Deporte> ObtenerDeportes() {
        return iDeporteRepository.findAll();
    }

    @Override
    public Deporte obtenerDeportePorNombre(String nombre) {
        return iDeporteRepository.findByNombre(nombre);
    }
}
