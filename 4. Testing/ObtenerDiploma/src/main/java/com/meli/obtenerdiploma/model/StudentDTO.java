package com.meli.obtenerdiploma.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@ToString
public class StudentDTO {
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe empezar en mayuscula.")
    @Size(max = 50, message = "La langitud del nombre no puede superar los 50 caracteres.")
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    String studentName;


    String message;

    @Positive
    Double averageScore;

    @NotNull
    @Size(min = 1, message = "Lista no puede estar vacia.")
    List< @Valid SubjectDTO> subjects;
}
