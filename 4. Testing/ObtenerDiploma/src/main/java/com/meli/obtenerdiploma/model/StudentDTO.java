package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp="^[A-Z].*", message ="El nombre del alumno debe iniciar con mayuscula" )
    @Size(max=50, message = "La longitud máxima del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @Size(min=1, message = "La lista no puede ser vacía")
    List<SubjectDTO> subjects;
}
