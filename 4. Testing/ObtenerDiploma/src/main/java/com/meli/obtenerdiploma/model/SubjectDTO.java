package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la materia debe comenzar con mayuscula.")
    @Size(max = 29, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @NotBlank(message = "El nombre de la materia no puede estar vacio.")
    String name;
    @NotNull(message = "La nota de la materia no puede estar vacia.")
    @DecimalMin(value = "0.0", message = "La nota de la materia no puede ser menor a 0.0")
    @DecimalMax(value = "10.0", message = "La nota de la materia no puede ser mayor a 10.0")
    Double score;
}
