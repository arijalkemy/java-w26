package com.example.ejercicio_dto_y_response_entity_p2.service.implementation;

import com.example.ejercicio_dto_y_response_entity_p2.dto.PersonaRiesgoDTO;
import com.example.ejercicio_dto_y_response_entity_p2.dto.SintomaDTO;
import com.example.ejercicio_dto_y_response_entity_p2.persistence.entity.Persona;
import com.example.ejercicio_dto_y_response_entity_p2.persistence.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService {
    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public SintomaServiceImpl() {
        Sintoma tos = new Sintoma(1, "Tos", "Bajo");
        Sintoma mocos = new Sintoma(2, "Mocos", "Medio");
        Sintoma fiebre = new Sintoma(3, "Fiebre", "Alto");

        sintomas = new ArrayList<>(){{
            add(tos);
            add(mocos);
            add(fiebre);
        }};

        Persona personaUno = new Persona(1, "Jose", "Hernandez", 70);
        personaUno.agregarSintoma(tos);
        Persona personaDos = new Persona(2, "Juan", "Fernandez", 60);
        personaDos.agregarSintoma(mocos);
        Persona personaTres = new Persona(3, "Pedro", "Funes", 59);
        Persona personaCuatro = new Persona(4, "Hector", "Ramos", 65);
        personaTres.agregarSintoma(tos);
        personaTres.agregarSintoma(mocos);
        personaTres.agregarSintoma(fiebre);

        personas = new ArrayList<>(){{
            add(personaUno);
            add(personaDos);
            add(personaTres);
            add(personaCuatro);
        }};
    }
    public List<Sintoma> obtenerSintomas() {
        return sintomas;
    }

    public String obtenerGravedadSintoma(String name) {
        for(Sintoma sintoma : sintomas) {
            if(sintoma.getNombre().equalsIgnoreCase(name)) {
                return sintoma.getNivelDeGravedad();
            }
        }
        return "No se encontró el sintoma!";
    }

    public List<PersonaRiesgoDTO> obtenerPersonasRiesgo() {
        List<PersonaRiesgoDTO> personasRiesgo = new ArrayList<>();
        for(Persona persona : personas) {
            if(persona.tieneSintomas() && persona.getEdad() >= 60) {
                List<SintomaDTO> sintomasDTO = new ArrayList<>();

                for(Sintoma sintoma : persona.getSintomas()) {
                    SintomaDTO sintomaDTO = new SintomaDTO(sintoma.getNombre(), sintoma.getNivelDeGravedad());
                    sintomasDTO.add(sintomaDTO);
                }

                PersonaRiesgoDTO personaDTO = new PersonaRiesgoDTO(persona.getNombre(), persona.getApellido(), sintomasDTO);
                personasRiesgo.add(personaDTO);
            }
        }
        return personasRiesgo;
    }
}
