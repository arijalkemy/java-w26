package com.example.deportistas.Service;

import com.example.deportistas.Entity.Deporte;

import java.util.List;

public interface DeporteService {

    public List<Deporte> todosLosDeportes();

    public int busquedaPorNombre(String nombre);
}
