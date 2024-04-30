package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayuscula.")
    @Size(max = 49, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @NotBlank(message = "El nombre del usuario no puede estar vacio.")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotEmpty(message = "La lista de materias no puede estar vacia")
    List<SubjectDTO> subjects;
}
