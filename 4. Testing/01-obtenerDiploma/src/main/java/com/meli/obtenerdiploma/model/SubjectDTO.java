package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacio.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota no puede estar vacia.")
    @Max(value = 10, message= "La nota maxima es 10.")
    @Min(value = 0, message= "La nota minima es 0.")
    Double score;
}
