package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp="^[A-Z].*", message ="El nombre del alumno debe iniciar con mayuscula" )
    @Max(value=50, message = "La longitud máxima del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @Min(value=1, message = "La lista no puede ser vacía")
    List<SubjectDTO> subjects;
}
