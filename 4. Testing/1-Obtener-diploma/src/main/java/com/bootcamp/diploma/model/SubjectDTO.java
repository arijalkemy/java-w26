package com.bootcamp.diploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 30 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    String name;
    @NotNull(message = "La nota no puede estar vacía")
    @Min(value = 0, message = "Debe ser mayor que 0")
    @Max(value = 10, message = "Debe ser menor que 10")
    Double score;
}
