package meli.bootcamp.deportistas.repositories;

import java.util.List;
import meli.bootcamp.deportistas.domain.Persona;

public class RepositorioPersonas {
  List<Persona> personas;

  public RepositorioPersonas(List<Persona> personas) {
    this.personas = personas;
  }

  public List<Persona> obtenerDeportistas() {
    return this.personas.stream().filter(Persona::esDeportista).toList();
  }
}
