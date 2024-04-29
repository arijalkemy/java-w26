package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre no puede estar vacío.")
    String studentName;

    @NotBlank(message = "El mensaje no puede estar vacío.")
    @Size(min = 1, max = 400, message = "El mensaje debe tener entre 1 y 400 caracteres.")
    String message;

    @NotNull(message = "El puntaje promedio no puede ser nulo.")
    @Min(value = 0, message = "El puntaje promedio debe ser mayor o igual a 0.")
    @Max(value = 10, message = "El puntaje promedio debe ser menor o igual a 10")
    Double averageScore;

    @NotNull(message = "La lista de materias no puede ser nula.")
    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<SubjectDTO> subjects;
}
