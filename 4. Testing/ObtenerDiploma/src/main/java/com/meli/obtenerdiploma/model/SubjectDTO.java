package com.meli.obtenerdiploma.model;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El campo nombre de la asignatura no puede ser vacio.")
    @Size(max = 30, message = "La langitud del nombre no puede superar los 30 caracteres." )
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la asignatura debe empezar en mayuscula.")
    String name;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    Double score;
}