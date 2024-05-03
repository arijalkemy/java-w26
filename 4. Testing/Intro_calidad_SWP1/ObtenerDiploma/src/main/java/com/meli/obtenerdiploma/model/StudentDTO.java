package com.meli.obtenerdiploma.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del estudiante no puede estar vacio")
    @Pattern(regexp = "([A-Z])", message = "El nombre del estudiante debe comenzar con mayuscula")
    @Size(max=50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres")
    String studentName;
    String message;
    @NotNull(message = "La nota de la materia no puede estar vacía.")
    @DecimalMax(value = "10.0", message = "La nota máxima de la materia es de 10 pts.")
    @DecimalMin(value = "0.0", message = "La nota mínima de la materia es de 0 pts.")
    Double averageScore;

    List<@NotBlank(message = "La lista no puede ser vacia") SubjectDTO> subjects;
}
