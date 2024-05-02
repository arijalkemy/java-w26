package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
@Valid
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar por mayúscula. ")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value= 0, message = "La mínima nota es 0.0 .")
    @Max(value= 10, message = "La máxima nota es 10.")
    Double score;
}
