package meli.bootcamp.deportistas.repositories;

import java.util.List;
import meli.bootcamp.deportistas.domain.Deporte;

public class RepositorioDeportes {
  List<Deporte> deportes;

  public RepositorioDeportes(List<Deporte> deportes) {
    this.deportes = deportes;
  }

  public void eliminarDeporte(Deporte deporte) {
    this.deportes.remove(deporte);
  }

  public void agregarDeporte(Deporte deporte) {
    this.deportes.add(deporte);
  }

  public List<Deporte> obtenerDeportes() {
    return this.deportes;
  }

  public Deporte obtenerPorNombre(String nombre) {
    return deportes.stream()
        .filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombre))
        .toList()
        .get(0);
  }
}
