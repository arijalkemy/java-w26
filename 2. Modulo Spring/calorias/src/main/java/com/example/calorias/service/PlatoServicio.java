package com.example.calorias.service;

import com.example.calorias.DTOs.PlatoDTO;
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

    public PlatoDTO obtenerPorNombre(String nombre) {

        Plato plato = platoRepositorio
                .getPlatos()
                .stream().filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);


        return
                new PlatoDTO(plato.getNombre()
                        , plato.getIngredientes()
                        , plato.getNroTotalCalorias()
                        , plato.obtenerIngredienteConMasCalorias());
    }
}
