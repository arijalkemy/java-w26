package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter @Setter
@Validated
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota no puede ser vacía.")
    @Min(message = "La nota mínima es 0.", value = 0)
    @Max(message = "La nota máxima es 10.", value = 10)
    Double score;
}
