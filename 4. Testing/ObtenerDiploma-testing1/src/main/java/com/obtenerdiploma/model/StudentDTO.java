package com.obtenerdiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty( message = "El nombre del alumno no puede estar vacio.")
    @Length(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern( regexp = "(^[A-Z].*)", message = "El nombre del alumno debe comenzar con mayuscula")
    String studentName;

    String message;
    Double averageScore;

    @Valid
    @NotNull( message = "La lista de sujetos no puede ser nula.")
    @NotEmpty( message = "La lista de sujetos no puede estar vacia.")
    List<SubjectDTO> subjects;
}
