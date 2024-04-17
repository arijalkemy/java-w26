package meli.bootcamp.star_wars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonajeDto {
  @JsonProperty("nombre")
  String name;

  @JsonProperty("altura")
  Double height;

  @JsonProperty("peso")
  Double mass;

  @JsonProperty("color_de_pelo")
  String hairColor;

  @JsonProperty("anio_de_nacimiento")
  String birthYear;
}
