package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IStarWarsService {
    List<PersonajeDTO> buscarPersonajesPorNombre(String nombre);
}
