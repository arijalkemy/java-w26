package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    @NotBlank(message = "Este campo no puede estar vacio")
    String name;
    @NotNull(message = "Este campo es requerido")
    @Positive(message = "Debe ser mayor a 0")
    Double score;
}
