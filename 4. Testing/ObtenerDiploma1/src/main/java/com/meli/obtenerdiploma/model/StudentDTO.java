package com.meli.obtenerdiploma.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacio")
    @Size(min = 2, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacia")
    @Valid
    List<SubjectDTO> subjects;


}
