package meli.bootcamp.star_wars.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import meli.bootcamp.star_wars.domain.Personaje;
import meli.bootcamp.star_wars.repository.IRepositorioDePersonajes;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDePersonajesJson implements IRepositorioDePersonajes {
  List<Personaje> personajes;

  public RepositorioDePersonajesJson(ResourceLoader resourceLoader) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Resource resource = resourceLoader.getResource("classpath:static/starwars.json");
    personajes = objectMapper.readValue(
        resource.getInputStream(), new TypeReference<>() {
        });
  }

  @Override
  public List<Personaje> buscarPersonajePorNombre(String nombre) {
    return this.personajes.stream()
        .filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
        .toList();
  }

  @Override
  public List<Personaje> obtenerTodos() {
    return personajes;
  }
}
