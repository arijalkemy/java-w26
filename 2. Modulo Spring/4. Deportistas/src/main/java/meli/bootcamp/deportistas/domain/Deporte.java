package meli.bootcamp.deportistas.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Deporte {
  String nombre;
  int nivel;

  public Deporte(String nombre, int nivel) {
    this.nombre = nombre;
    this.nivel = nivel;
  }

}
