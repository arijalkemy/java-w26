package com.EjercicioSpring.Ejercicio7_Covid19.service;

import com.EjercicioSpring.Ejercicio7_Covid19.dto.PersonaAltoRiesgoDTO;
import com.EjercicioSpring.Ejercicio7_Covid19.dto.SintomaDTO;
import com.EjercicioSpring.Ejercicio7_Covid19.entity.Persona;
import com.EjercicioSpring.Ejercicio7_Covid19.entity.Sintoma;
import com.EjercicioSpring.Ejercicio7_Covid19.repository.PersonaRepository;
import com.EjercicioSpring.Ejercicio7_Covid19.repository.SintomaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SintomasService {

    private SintomaRepository sintomaRepository = new SintomaRepository();
    private PersonaRepository personaRepository = new PersonaRepository();

    public List<SintomaDTO> getSintomas() {
        List<Sintoma> sintomas = sintomaRepository.getAll();
        List<SintomaDTO> sintomasDTO = new ArrayList<>();
        for (Sintoma sintoma : sintomas) {
            sintomasDTO.add(new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad()));
        }
        return sintomasDTO;
    }

    public String getSintomaByName(String name) {
        return sintomaRepository.getAll().stream()
                .filter(x -> x.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .map(Sintoma::getNivelDeGravedad) // Devuelve el nivel de gravedad si está presente
                .orElse("No se encontró el síntoma");
    }

    public List<PersonaAltoRiesgoDTO> getPersonasAltoRiesgo() {
        List<Persona> personas = personaRepository.getAll();
        return personas.stream()
                .filter(x -> x.getEdad() >= 60)
                .map(x -> new PersonaAltoRiesgoDTO(x.getNombre(), x.getApellido()))
                .toList();
    }
}
