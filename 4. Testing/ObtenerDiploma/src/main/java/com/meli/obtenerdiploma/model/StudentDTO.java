package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El valor no puede estar vacio")
    String studentName;


    @NotBlank(message = "El valor no puede estar vacio")
    String message;

    @NotNull(message = "El valor no puede ser nulo")
    Double averageScore;

    @Size(min = 0, max = 8, message = "La cantidad debe ser menor o igual a 0")
    List<SubjectDTO> subjects;
}
