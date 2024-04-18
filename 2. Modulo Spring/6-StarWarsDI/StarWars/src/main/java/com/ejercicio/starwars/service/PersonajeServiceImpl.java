package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.PersonajeDTO;
import com.ejercicio.starwars.entity.Personaje;
import com.ejercicio.starwars.repository.IRepositorioPersonajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonajeServiceImpl implements IPersonajeService{


    @Autowired
    IRepositorioPersonajes repositorio;

    @Override
    public List<PersonajeDTO> getPersonajePorNombre(String nombre) {
        List<Personaje> listaPersonajes = new ArrayList<>();
        List<PersonajeDTO> listaDTORespuesta = new ArrayList<>();

        listaPersonajes = repositorio.getPersonajes().stream()
                .filter(p -> p.getName().contains(nombre))
                .toList();

        listaPersonajes.forEach(p -> listaDTORespuesta.add(new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies())));

        return listaDTORespuesta;
    }
}
