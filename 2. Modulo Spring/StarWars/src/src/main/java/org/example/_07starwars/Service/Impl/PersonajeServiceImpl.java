package org.example._07starwars.Service.Impl;

import org.example._07starwars.DTO.PersonajeDTO;
import org.example._07starwars.Model.Personaje;
import org.example._07starwars.Repository.IRepositorio;
import org.example._07starwars.Service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    IRepositorio repositorioPersonajes;

    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        List<Personaje> personajes = repositorioPersonajes.buscarPorNombre(nombre);
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        personajes.forEach(p -> personajesDTO.add(new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies())));
        return personajesDTO;
    }
}
