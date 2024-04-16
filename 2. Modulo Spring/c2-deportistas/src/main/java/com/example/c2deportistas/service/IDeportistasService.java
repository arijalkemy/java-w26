package com.example.c2deportistas.service;

import com.example.c2deportistas.domain.Deporte;
import com.example.c2deportistas.domain.Persona;
import com.example.c2deportistas.dto.PersonaDTO;

import java.util.List;

public interface IDeportistasService {
     List<Deporte> consultarDeportes();
     Deporte existeDeporte(String nombre);
     PersonaDTO consultarPersonaDeportista();

}
