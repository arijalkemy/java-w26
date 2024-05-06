package com.viajescuidados.services.interfaces;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;

public interface IPersonasService {
    PersonaResponseDTO crearPersona(PersonaDTO personaDTO);
    PersonaResponseDTO buscarPersona(Integer id);
}
