package org.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede ser vacía")
    @Size(min = 3, max = 30, message = "La longitud de la materia no puede superar los 30 caracteres")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message="El nombre de la materia debe comenzar en mayuscula")
    String name;
    @NotNull(message = "La nota no puede ser vacía")
    @DecimalMax(value = "10.0", message="La maxima nota es 10")
    @DecimalMin(value = "0.0", message = "La minimo nota es 0")
    Double score;
}
