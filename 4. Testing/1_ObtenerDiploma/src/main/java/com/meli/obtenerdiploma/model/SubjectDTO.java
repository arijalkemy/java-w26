package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message="El nombre de la materia debe comenzar en mayuscula")
    @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;
    @NotNull(message = "La nota no puede estar vacía")
    @Min(value = 0,message = "La mínima nota es 0.0")
    @Max(value = 10,message = "La máxima nota es 10.0")
    Double score;
}
