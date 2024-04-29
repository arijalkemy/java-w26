package com.testing.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud de la materia no puede superar los 30 caracteres.")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;

    @Min(value = 0, message = "La mínima nota es de 0.0")
    @Max(value = 10, message = "La máxima nota es 10.0")
    @NotNull(message ="La nota no puede estar vacía." )
    Double score;
}
