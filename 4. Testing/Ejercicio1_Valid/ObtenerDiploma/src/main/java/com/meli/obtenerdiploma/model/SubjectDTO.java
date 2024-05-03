package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectDTO {
    @NotBlank (message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull
    @Min(value = 0, message = "La mínima nota es 0.0")
    @Max(value = 10, message = "La máxima nota es 10.0")
    Double score;
}
