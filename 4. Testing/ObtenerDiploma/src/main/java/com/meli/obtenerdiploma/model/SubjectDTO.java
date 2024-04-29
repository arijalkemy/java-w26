package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "Ingrese nombre de materia")
    @Pattern(regexp = "(?=[A-Z])[\\p{L}0-9\\p{Punct} ]*",
            message = "Ingresar un nombre de materia que empiece con mayúscula")
    @Length(max = 30, message = "El nombre de la materia debe tener a lo sumo 30 caracteres")
    String name;

    @NotNull(message = "La nota no puede ser null")
    @Min(value = 0, message = "La nota debe ser >= 0") @Max(value = 10, message = "La nota debe ser <= 10")
    Double score;
}
