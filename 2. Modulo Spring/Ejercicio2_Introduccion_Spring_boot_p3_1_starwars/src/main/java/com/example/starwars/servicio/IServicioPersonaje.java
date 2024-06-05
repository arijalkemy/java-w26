package com.example.starwars.servicio;

import com.example.starwars.dto.DTOPersonaje;
import com.example.starwars.modelo.Personaje;

import java.util.List;

public interface IServicioPersonaje {
    public List<Personaje> generarListaPersonaje();
    public List<DTOPersonaje> generarListaPersonajePorFiltro(String filtro);
}
