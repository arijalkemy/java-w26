package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "el campo de studentName es requerido")
    @NotBlank(message = "el campo de studentName no puede ir vacio")
    @NotEmpty(message = "el campo de studentName no puede ir vacio")
    @Min(message = "el nombre de estudiante debe contener minimo 3 caracteres", value = 3)
    String studentName;

    @NotNull(message = "el campo de message es requerido")
    @NotBlank(message = "el campo de message no puede ir vacio")
    @NotEmpty(message = "el campo de message no puede ir vacio")
    @Min(message = "el campo de message debe contener minimo 10 caracteres", value = 3)
    String message;

    @NotNull(message = "el campo averageScore es requerido")
    @PositiveOrZero(message = "el campo de averageScore debe ser positivo o cero")
    Double averageScore;

    @Valid
    List<SubjectDTO> subjects;
}
