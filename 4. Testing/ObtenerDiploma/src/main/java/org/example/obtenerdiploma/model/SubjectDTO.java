package org.example.obtenerdiploma.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede ser nulo")
    @NotBlank(message = "El nombre de la materia no puede ser vacío")
    String name;

    @NotNull(message = "La nota de la materia no puede ser nula")
    Double score;
}
