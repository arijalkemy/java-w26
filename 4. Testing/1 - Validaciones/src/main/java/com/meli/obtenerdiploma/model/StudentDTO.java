package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El campo nombre de estudiante no puede ser nulo o vacío")
    
    String studentName;
    String message;
    Double averageScore;
    List<SubjectDTO> subjects;
}
