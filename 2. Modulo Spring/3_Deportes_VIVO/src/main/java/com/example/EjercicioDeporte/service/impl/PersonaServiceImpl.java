package com.example.EjercicioDeporte.service.impl;

import com.example.EjercicioDeporte.dto.PersonaDTO;
import com.example.EjercicioDeporte.model.Persona;
import com.example.EjercicioDeporte.repository.Repository;
import com.example.EjercicioDeporte.service.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Override
    public List<PersonaDTO> buscarPersonasDeportistas() {

        return Repository.personas.stream()
            .filter(persona -> persona.getDeporte() != null)
            .map(PersonaServiceImpl::convertirADTO)
            .toList();
    }

    private static PersonaDTO convertirADTO(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());

        if(persona.getDeporte() != null)
            dto.setDeporte(persona.getDeporte().getNombre());

        return dto;
    }

}
