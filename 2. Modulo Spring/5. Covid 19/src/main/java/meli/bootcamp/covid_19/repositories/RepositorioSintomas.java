package meli.bootcamp.covid_19.repositories;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import meli.bootcamp.covid_19.domain.Sintoma;

@AllArgsConstructor
public class RepositorioSintomas {
  List<Sintoma> sintomas;

  public void agregarSintoma(Sintoma unSintoma) {
    this.sintomas.add(unSintoma);
  }

  public List<Sintoma> obtenerSintomas() {
    return this.sintomas;
  }

  public List<Sintoma> obtenerSintomaPorNombre(String nombre) {
    return this.sintomas.stream()
        .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre))
        .collect(Collectors.toList());
  }
}
