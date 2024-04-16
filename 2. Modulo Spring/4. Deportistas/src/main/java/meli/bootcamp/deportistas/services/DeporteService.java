package meli.bootcamp.deportistas.services;

import java.util.List;
import meli.bootcamp.deportistas.domain.Deporte;
import meli.bootcamp.deportistas.repositories.RepositorioDeportes;
import org.springframework.stereotype.Service;

@Service
public class DeporteService {

  private final RepositorioDeportes repo;

  public DeporteService() {
    this.repo = new RepositorioDeportes(
        List.of(
            new Deporte("Futbol", 5),
            new Deporte("Tenis", 3),
            new Deporte("Voley", 4),
            new Deporte("Rugby", 5),
            new Deporte("Hockey", 4)
        )
    );
  }

  public List<Deporte> findSports() {
    return this.repo.obtenerDeportes();
  }

  public Deporte obtenerPorNombre(String nombre) {
    return this.repo.obtenerPorNombre(nombre);
  }
}
