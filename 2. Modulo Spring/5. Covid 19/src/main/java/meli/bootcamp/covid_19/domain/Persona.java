package meli.bootcamp.covid_19.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
  Long id;
  String nombre;
  String apellido;
  Integer edad;
  List<Sintoma> sintomas;

  public void agregarSintoma(Sintoma unSintoma) {
    this.sintomas.add(unSintoma);
  }

}
