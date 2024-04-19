package com.example.starwars.service.impl;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.IRepository;
import com.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    IRepository personajesRepository;

    @Override
    public PersonajeDto obtenerPersonaje(String nombre) {
        Optional<Personaje> personaje = personajesRepository.getData().stream().filter( x ->
            x.getName().contains(nombre)
        ).findFirst();
        if( personaje.isEmpty() ){
            return null;
        }
        return new PersonajeDto( personaje.get() );
    }

    @Override
    public void crearPersonajes(List<Personaje> personajes) {
        personajesRepository.postData(personajes);
    }

}
