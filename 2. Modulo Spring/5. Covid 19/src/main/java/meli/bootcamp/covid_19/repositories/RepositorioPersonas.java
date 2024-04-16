package meli.bootcamp.covid_19.repositories;

import java.util.List;
import lombok.AllArgsConstructor;
import meli.bootcamp.covid_19.domain.Persona;

@AllArgsConstructor
public class RepositorioPersonas {
  List<Persona> personas;

  public void agregarPersona(Persona unaPersona) {
    this.personas.add(unaPersona);
  }

  public List<Persona> obtenerPersonas() {
    return this.personas;
  }

  public List<Persona> obtenerPersonasConRiesgo() {
    return this.personas.stream().filter(Persona::esDeRiesgo).toList();
  }
}

