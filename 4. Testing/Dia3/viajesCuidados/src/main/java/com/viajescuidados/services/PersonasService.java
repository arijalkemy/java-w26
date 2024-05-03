package com.viajescuidados.services;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.mappers.PersonaMapper;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.interfaces.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonasService implements IPersonasService, IPersonaServiceInternal {
    @Autowired
    private IPersonasRepository personasRepository;

    @Override
    public PersonaResponseDTO crearPersona(PersonaDTO personaDTO) {
        Persona nuevaPersona = PersonaMapper.crearPersona(personaDTO);
        this.personasRepository.guardar(nuevaPersona);
        return PersonaMapper.crearPersonaResponseDTO(nuevaPersona);
    }

    @Override
    public PersonaResponseDTO buscarPersona(Integer id) {
        Persona personaBuscada = buscarPersonaPorId(id);
        return PersonaMapper.crearPersonaResponseDTO(personaBuscada);
    }

    @Override
    public Persona buscarPersonaPorId(Integer id) {
        Optional<Persona> posiblePersona = this.personasRepository.buscarPorId(id);

        if(posiblePersona.isEmpty())
            throw new NotFoundException("No se ha encontrado una persona con el id " + id +" brindado");

        return posiblePersona.get();
    }
}
