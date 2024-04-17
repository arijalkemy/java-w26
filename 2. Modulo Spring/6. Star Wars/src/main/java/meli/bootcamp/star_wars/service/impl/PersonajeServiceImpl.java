package meli.bootcamp.star_wars.service.impl;

import java.util.List;
import meli.bootcamp.star_wars.domain.Personaje;
import meli.bootcamp.star_wars.repository.IRepositorioDePersonajes;
import meli.bootcamp.star_wars.service.IPersonajeService;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
  IRepositorioDePersonajes repositorioDePersonajes;

  PersonajeServiceImpl(IRepositorioDePersonajes repositorioDePersonajes) {
    this.repositorioDePersonajes = repositorioDePersonajes;
  }

  @Override
  public Personaje buscarPersonajePorNombre(String nombre) {
    return repositorioDePersonajes.buscarPersonajePorNombre(nombre);
  }

  @Override
  public List<Personaje> obtenerPersonajes() {
    return repositorioDePersonajes.obtenerTodos();
  }
}
