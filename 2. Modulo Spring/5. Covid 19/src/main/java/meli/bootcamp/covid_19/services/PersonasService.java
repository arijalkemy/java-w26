package meli.bootcamp.covid_19.services;

import java.util.List;
import meli.bootcamp.covid_19.domain.NivelDeGravedad;
import meli.bootcamp.covid_19.domain.Persona;
import meli.bootcamp.covid_19.domain.Sintoma;
import meli.bootcamp.covid_19.dto.PersonaDto;
import meli.bootcamp.covid_19.repositories.RepositorioPersonas;
import org.springframework.stereotype.Service;

@Service
public class PersonasService {
  RepositorioPersonas repositorioPersonas;

  public PersonasService() {
    this.repositorioPersonas = new RepositorioPersonas(
        List.of(
            new Persona("Juan", "Perez", 25, List.of(
                new Sintoma("f123", "Conjuntivitis", NivelDeGravedad.GRAVE),
                new Sintoma("g123", "Dolor de cabeza", NivelDeGravedad.MODERADO))
            ),
            new Persona("Maria", "Gomez", 30, List.of(
                new Sintoma("a123", "Tos seca", NivelDeGravedad.LEVE),
                new Sintoma("b123", "Fiebre", NivelDeGravedad.MODERADO))
            ),
            new Persona("Pedro", "Gonzalez", 40, List.of(
                new Sintoma("e123", "Diarrea", NivelDeGravedad.GRAVE),
                new Sintoma("f123", "Conjuntivitis", NivelDeGravedad.GRAVE))
            ),
            new Persona("Laura", "Rodriguez", 50, List.of(
                new Sintoma("a123", "Tos seca", NivelDeGravedad.LEVE),
                new Sintoma("b123", "Fiebre", NivelDeGravedad.MODERADO))
            ),
            new Persona("Carlos", "Lopez", 60, List.of(
                new Sintoma("a123", "Tos seca", NivelDeGravedad.LEVE),
                new Sintoma("b123", "Fiebre", NivelDeGravedad.MODERADO))
            ),
            new Persona("Ana", "Martinez", 70, List.of(
                new Sintoma("e123", "Diarrea", NivelDeGravedad.GRAVE),
                new Sintoma("f123", "Conjuntivitis", NivelDeGravedad.GRAVE))
            )
        )
    );
  }

  public List<PersonaDto> obtenerPersonasConRiesgo() {
    return this.repositorioPersonas.obtenerPersonasConRiesgo().stream()
        .map(p -> new PersonaDto(p.getNombre(), p.getApellido(), p.getEdad()))
        .toList();
  }
}
