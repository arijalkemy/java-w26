package meli.bootcamp.covid_19.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
  String codigo;
  String nombre;
  NivelDeGravedad nivelDeGravedad;
}
