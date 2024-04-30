package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 30, message = "La longitud del nombre del alumno no puede superar los {max} caracteres")
    @Pattern(regexp = "[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula")
    String name;
    @NotNull(message = "la nota no puede estar vacía")
    @Min(value = 0, message = "La mínima nota es {value}")
    @Max(value = 10, message = "La máxima nota es {value}")
    Double score;
}
