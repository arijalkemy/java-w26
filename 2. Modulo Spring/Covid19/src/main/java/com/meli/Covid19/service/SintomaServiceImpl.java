package com.meli.Covid19.service;

import com.meli.Covid19.models.Persona;
import com.meli.Covid19.models.Sintoma;
import com.meli.Covid19.dto.PersonaDeRiesgoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService{

    private Sintoma sintomaUno = new Sintoma("1", "Fiebre", "Alto");
    private Sintoma sintomaDos = new Sintoma("2", "Tos", "Medio");
    private Sintoma sintomaTres = new Sintoma("3", "Cansancio", "Bajo");

    private final List<Sintoma> sintomaList = List.of(sintomaUno, sintomaDos, sintomaTres);

    private Persona personaUno = new Persona("1", "PersonaUno", "Uno", 70, List.of(sintomaUno, sintomaDos));
    private Persona personaDos = new Persona("2", "PersonaDos", "Dos", 25);

    private final List<Persona> personasList = List.of(personaUno, personaDos);

    @Override
    public List<Sintoma> buscarSintomas() {
        return sintomaList;
    }

    @Override
    public String buscarNivelDeGravedad(String nombre) {
        Sintoma sintomaEncontrado = sintomaList.stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        return sintomaEncontrado != null ? sintomaEncontrado.getNivelDeGravedad() : null;
    }

    @Override
    public List<PersonaDeRiesgoDTO> buscarPersonasDeRiesgo() {
        return personasList.stream()
                .filter(persona -> persona.getEdad() > 60 && !persona.getSintomasAsociados().isEmpty())
                .map(persona -> new PersonaDeRiesgoDTO(persona.getNombre(), persona.getApellido()))
                .toList();
    }
}
