package org.example.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede ser nulo")
    @NotBlank(message = "El nombre de la materia no puede ser vacío")
    @Max(value = 30, message = "El nombre del estudiante no puede tener más de 30 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del estudiante debe comenzar con una letra mayúscula")
    String name;

    @NotNull(message = "La nota de la materia no puede ser nula")
    @Max(value = 10, message = "La nota de la materia no puede ser mayor a 10")
    @Min(value = 0, message = "La nota de la materia no puede ser menor a 0")
    Double score;
}
