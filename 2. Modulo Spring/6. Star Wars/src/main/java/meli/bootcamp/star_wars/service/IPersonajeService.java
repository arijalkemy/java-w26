package meli.bootcamp.star_wars.service;

import java.util.List;
import meli.bootcamp.star_wars.domain.Personaje;

public interface IPersonajeService {
  Personaje buscarPersonajePorNombre(String nombre);

  List<Personaje> obtenerPersonajes();
}
