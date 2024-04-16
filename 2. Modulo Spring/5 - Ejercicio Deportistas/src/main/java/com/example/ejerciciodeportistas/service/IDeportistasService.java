package com.example.ejerciciodeportistas.service;

import com.example.ejerciciodeportistas.clases.Deporte;
import com.example.ejerciciodeportistas.clases.Deportista;

import java.util.List;

public interface IDeportistasService {

    public List<Deporte> obtenerDeportes();

    public Deporte obtenerDeporte( String nombre );

    public List<Deportista> obtenerDeportistas();
}
