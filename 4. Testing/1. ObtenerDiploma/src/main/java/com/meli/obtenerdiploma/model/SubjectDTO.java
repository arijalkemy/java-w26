package com.meli.obtenerdiploma.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
  @NotBlank(message = "El nombre de la materia no puede estar vacío.")
  @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 30 caracteres.")
  String name;

  @NotNull(message = "La nota de la materia no puede estar vacía.")
  @DecimalMax(value = "10.0", message = "La nota máxima de la materia es de 10 pts.")
  @DecimalMin(value = "0.0", message = "La nota mínima de la materia es de 0 pts.")
  Double score;
}
