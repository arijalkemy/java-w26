package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

    @NotNull(message = "El nombre de la materia no puede estar vacio.")
    @Pattern(regexp = "^[A-Z].*$", message =  "el nombre de la materia debe empezar con mayuscula")
    @Size(max = 30, message = "La longitud del nombre no debe superar los 30 caracteres.")
    String name;


    @NotNull(message = "La materia no puede tener nota vacia.")
    @Min(value = 0, message = "La nota minima debe ser 0.0.")
    @Max(value = 10, message = "La nota minima debe ser 0.0.")
    Double score;
}
