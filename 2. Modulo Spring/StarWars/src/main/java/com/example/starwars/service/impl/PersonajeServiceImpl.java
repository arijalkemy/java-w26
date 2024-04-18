package com.example.starwars.service.impl;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.PersonajeRepository;
import com.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    PersonajeRepository _repository;

    @Override
    public List<PersonajeDTO> personajesPorNombre(String nombre) {
        List<Personaje> personajeList = _repository.loadDataBase();
        List<PersonajeDTO> personajeDTOList = new ArrayList<>();
        personajeList.stream()
                .filter(p -> p.getName().toUpperCase().contains(nombre.toUpperCase()))
                .forEach(p -> personajeDTOList.add(new PersonajeDTO(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies()
                )));

        return personajeDTOList;
    }
}
