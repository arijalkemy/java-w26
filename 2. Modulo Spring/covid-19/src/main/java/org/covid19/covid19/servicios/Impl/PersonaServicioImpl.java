package org.covid19.covid19.servicios.Impl;

import org.covid19.covid19.dto.PersonaDto;
import org.covid19.covid19.entidades.NivelDeGravedad;
import org.covid19.covid19.entidades.Persona;
import org.covid19.covid19.entidades.Sintoma;
import org.covid19.covid19.repositorios.RepositorioPersona;
import org.covid19.covid19.repositorios.RepositorioSintoma;
import org.covid19.covid19.servicios.IPersonaServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicioImpl implements IPersonaServicio {
    RepositorioPersona repositorioPersona;

    public PersonaServicioImpl() {
        this.repositorioPersona = new RepositorioPersona(List.of(

                new Persona("Pepe", "Rodriguez", 61, List.of(
                        new Sintoma("arn90", "fiebre", NivelDeGravedad.MEDIO),
                        new Sintoma("arn90", "Dificultad para respirar", NivelDeGravedad.GRAVE))
                ),
                new Persona("Maria", "Rodriguez", 20, List.of(
                        new Sintoma("arn90", "tos seca", NivelDeGravedad.LEVE),
                        new Sintoma("arn90", "Dificultad para respirar", NivelDeGravedad.GRAVE))),
                new Persona("Pedro", "Rodriguez", 80, List.of(
                        new Sintoma("arn90", "fiebre", NivelDeGravedad.MEDIO),
                        new Sintoma("arn90", "Dificultad para respirar", NivelDeGravedad.GRAVE)))

                )
        );
    }

    public List<PersonaDto> obtenerPersonasDeRiesgo(){
       return this.repositorioPersona.obtenerPersonas().stream()
                .filter(p -> p.getEdad() > 60 && p.getSintomas().size() >= 1)
                .map(this::crearPersonaDto)
                .toList();
    }

    public PersonaDto crearPersonaDto(Persona persona){
        return new PersonaDto(persona.getNombre(), persona.getApellido());
    }
}
