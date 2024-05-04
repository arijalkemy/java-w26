package com.meli.obtenerdiploma.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@Getter
@Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String name;

    @NotNull(message = "La nota no puede estar vacia")
    @Min(value = 0 , message = "La nota minima es 0.0")
    @Max(value = 10, message = "La nota maxima es 10.0")
    Double score;
}
