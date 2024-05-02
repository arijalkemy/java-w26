package com.obtenerdiploma.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty( message = "El nombre del subject no puede estar vacio.")
    String name;
    @Min(value = 0, message = "Valor minimo 0")
    Double score;
}
