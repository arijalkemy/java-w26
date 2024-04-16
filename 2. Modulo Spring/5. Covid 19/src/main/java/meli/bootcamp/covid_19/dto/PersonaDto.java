package meli.bootcamp.covid_19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
  String nombre;
  String apellido;
  Integer edad;
}
