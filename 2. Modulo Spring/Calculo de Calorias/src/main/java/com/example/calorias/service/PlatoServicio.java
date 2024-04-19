package com.example.calorias.service;

import com.example.calorias.DTOs.IngredienteDTO;
import com.example.calorias.DTOs.PlatoDTO;
import com.example.calorias.modelo.Ingrediente;
import com.example.calorias.modelo.Plato;
import com.example.calorias.repositorios.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServicio {

    final PlatoRepositorio platoRepositorio;

    public PlatoServicio(PlatoRepositorio platoRepositorio) {
        this.platoRepositorio = platoRepositorio;
    }


    public List<PlatoDTO> obtenerTodosLosPlatos(){
        return platoRepositorio.getPlatos();
    }


    public PlatoDTO obtenerPorNombre(String nombre) {
        return platoRepositorio
                .getPlatos()
                .stream().filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public IngredienteDTO obtenerIngredienteConMayorNumeroCalorias(String nombre){
        return platoRepositorio.getPlatos().stream().map(p -> p.getIngredienteConMasCalorias()).findFirst().orElse(null);
    }
}
