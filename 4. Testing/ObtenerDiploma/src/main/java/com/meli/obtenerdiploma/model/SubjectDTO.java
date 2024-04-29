package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre no puede ser nulo.")
    String name;

    @NotNull(message = "El puntaje no puede ser nulo.")
    @Min(value = 0, message = "El puntaje no puede ser negativo")
    @Max(value = 10, message = "El puntaje no puede ser mayor a 10")
    Double score;
}
