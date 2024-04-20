package com.example.demo.service.imp;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.model.Personaje;
import com.example.demo.repository.IStarWarsRepository;
import com.example.demo.service.IStarWarsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements IStarWarsService {

    private final IStarWarsRepository starWarsRepository;

    @Autowired
    public StarWarsService(IStarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    public List<PersonajeDTO> buscarPersonajesPorNombre(String nombre) {
        List<Personaje> personajes = starWarsRepository.buscarPersonajesPorNombre(nombre);
        return convertirAPersonajesDTO(personajes);
    }

    private List<PersonajeDTO> convertirAPersonajesDTO(List<Personaje> personajes) {
        return personajes.stream()
                .map(this::convertirAPersonajeDTO)
                .collect(Collectors.toList());
    }

    private PersonajeDTO convertirAPersonajeDTO(Personaje personaje) {
        ObjectMapper mapper = new ObjectMapper();

        PersonajeDTO dto = new PersonajeDTO();
        dto = mapper.convertValue(personaje, PersonajeDTO.class);

        /*
        PersonajeDTO dto = new PersonajeDTO();
        dto.setName(personaje.getName());
        dto.setHeight(personaje.getHeight());
        dto.setMass(personaje.getMass());
        dto.setGender(personaje.getGender());
        dto.setHomeworld(personaje.getHomeworld());
        dto.setSpecies(personaje.getSpecies());
         */
        return dto;
    }

}
