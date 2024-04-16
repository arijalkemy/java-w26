package meli.bootcamp.deportistas.services;

import java.util.List;
import meli.bootcamp.deportistas.domain.Deporte;
import meli.bootcamp.deportistas.domain.Persona;
import meli.bootcamp.deportistas.repositories.RepositorioPersonas;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

  private final RepositorioPersonas repo;

  public PersonaService() {
    Persona juan = new Persona("Juan", "Perez", 20);
    juan.asignarDeporte(new Deporte("Fútbol", 5));

    this.repo = new RepositorioPersonas(
        List.of(
            juan,
            new Persona("Lucas", "Gomez", 30),
            new Persona("Ana", "Fernandez", 25),
            new Persona("Luis", "Rodriguez", 35)
        )
    );
  }

  public List<Persona> findSportsPersons() {
    return this.repo.obtenerDeportistas();
  }
}
