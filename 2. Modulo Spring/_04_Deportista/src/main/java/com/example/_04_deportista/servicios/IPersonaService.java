package com.example._04_deportista.servicios;

import com.example._04_deportista.model.DTO.PersonaDeportistaDTO;
import com.example._04_deportista.model.Persona;

import java.util.List;

public interface IPersonaService {
    public List<PersonaDeportistaDTO> obtenerPersonas();
}
