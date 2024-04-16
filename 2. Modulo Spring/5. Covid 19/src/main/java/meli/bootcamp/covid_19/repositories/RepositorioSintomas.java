package meli.bootcamp.covid_19.repositories;

import java.util.List;
import lombok.AllArgsConstructor;
import meli.bootcamp.covid_19.domain.Sintoma;

@AllArgsConstructor
public class RepositorioSintomas {
  List<Sintoma> sintomas;

  public void agregarSintoma(Sintoma unSintoma) {
    this.sintomas.add(unSintoma);
  }

  public List<Sintoma> obtenerPersonas() {
    return this.sintomas;
  }

}
