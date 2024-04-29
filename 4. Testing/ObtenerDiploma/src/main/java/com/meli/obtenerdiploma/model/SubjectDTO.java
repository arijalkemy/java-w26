package com.meli.obtenerdiploma.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank
    String name;

    @NotNull
    Double score;
}
