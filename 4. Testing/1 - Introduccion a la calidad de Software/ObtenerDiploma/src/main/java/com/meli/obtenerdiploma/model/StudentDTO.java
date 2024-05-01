package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "el campo de studentName es requerido")
    @NotEmpty(message = "el campo de studentName no puede estar vacio")
    @Size(message = "el campo de studentName debe tener como minimo 5 caracteres")
    String studentName;

    @NotNull(message = "el campo de message es requerido")
    @NotEmpty(message = "el campo de message no puede estar vacio")
    String message;


    @NotNull(message = "el campo de averageScore es requerido")
    @PositiveOrZero(message = "el campo de averageScore debe ser positivo o cero")
    Double averageScore;

    @Valid
    @Size(min = 1, message = "la lista de subjects debe de contener al menos un subject")
    List<SubjectDTO> subjects;
}
