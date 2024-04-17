package com.example.deportista.service.serviceImpl;

import com.example.deportista.entities.Deporte;
import com.example.deportista.repository.DeporteRepository;
import com.example.deportista.service.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteImpl implements IDeporte {

    DeporteRepository deporteRepository;


    @Autowired
    DeporteImpl(DeporteRepository deporteRepository){
        this.deporteRepository = deporteRepository;
    }

    @Override
    public List<Deporte> ObtenerDeportes() {
        return deporteRepository.obtenerDeportes();
    }
}
