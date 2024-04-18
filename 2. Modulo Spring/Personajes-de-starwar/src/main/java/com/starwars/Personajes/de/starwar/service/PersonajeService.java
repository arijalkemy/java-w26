package com.starwars.Personajes.de.starwar.service;

import com.starwars.Personajes.de.starwar.dto.ResponsePersonajeDto;
import com.starwars.Personajes.de.starwar.entity.Personaje;
import com.starwars.Personajes.de.starwar.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    IRepository<Personaje> personajeRepository;

    @Autowired
    public PersonajeService(IRepository<Personaje> personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<Personaje> findAll(){
        return personajeRepository.findAll();
    }

    public ResponsePersonajeDto findByName(String name){
        Optional<Personaje> optionalPersonaje = personajeRepository.findByName(name);
        if(optionalPersonaje.isPresent()){
            Personaje personaje = optionalPersonaje.get();
            return parsePersonToDto(personaje);
        }
        else{
            return new ResponsePersonajeDto();
        }
    }

    private ResponsePersonajeDto parsePersonToDto(Personaje personaje){
        return new ResponsePersonajeDto(personaje.getName(),personaje.getHeight(),personaje.getMass(),personaje.getGender(),personaje.getHomeworld(),personaje.getSpecies());
    }
}
