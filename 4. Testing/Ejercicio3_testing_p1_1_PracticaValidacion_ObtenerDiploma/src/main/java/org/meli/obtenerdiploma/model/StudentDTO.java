package org.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "Nombre del alumno no puede estar vacio")
    @Size(min = 3, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message="El nombre del alumno debe comenzar en mayuscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacia")
    @Valid
    List<SubjectDTO> subjects;
}
