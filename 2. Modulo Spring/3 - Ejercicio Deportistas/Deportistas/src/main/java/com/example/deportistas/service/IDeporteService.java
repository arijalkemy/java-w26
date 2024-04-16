package com.example.deportistas.service;

import com.example.deportistas.model.Deporte;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeporteService {

    public List<Deporte> TodoDeportes();

    public int verDeporte(String nombre);
}
