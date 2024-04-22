package org.miprimerproyecto.starwarsvivo.services;

import org.miprimerproyecto.starwarsvivo.dto.PersonaDTO;
import org.miprimerproyecto.starwarsvivo.model.Persona;
import org.miprimerproyecto.starwarsvivo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImlp implements PersonaService {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImlp(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<PersonaDTO> findAll(String nombre) {
        List<Persona> PersonaAux=this.personaRepository.getPersonas().stream().filter(x-> x.getName().equals(nombre)).toList();
        List<PersonaDTO> personaDTOList= new ArrayList<>();
        for(Persona element: PersonaAux){
            personaDTOList.add(new PersonaDTO(element.getName(), element.getHeight(), element.getMass(), element.getGender(), element.getHomeworld(), element.getSpecies()));
        }
        return personaDTOList;
    }

}
