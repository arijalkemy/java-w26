package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp="^[A-Z].*", message ="El nombre del alumno debe iniciar con mayuscula" )
    @Max(value = 30, message = "La longitud del nombre no puede superar los 30 caracteres.") // Nota que he cambiado el valor a 30 según tu mensaje de error.
    String name;
    @NotNull(message = "La nota no puede estar vacía")
    @DecimalMax(value="10.0", message = "La nota máxima es de 10.0")
    @DecimalMin(value="0.0", message = "La nota mínima es de 0.0")
    Double score;

}
