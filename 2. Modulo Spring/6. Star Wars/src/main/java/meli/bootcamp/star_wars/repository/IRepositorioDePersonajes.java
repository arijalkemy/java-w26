package meli.bootcamp.star_wars.repository;

import java.util.List;
import meli.bootcamp.star_wars.domain.Personaje;

public interface IRepositorioDePersonajes {
  public Personaje buscarPersonajePorNombre(String nombre);

  List<Personaje> obtenerTodos();
}
