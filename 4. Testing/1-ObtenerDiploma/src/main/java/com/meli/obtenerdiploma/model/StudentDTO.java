package com.meli.obtenerdiploma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {
    @NotNull(message = "Ingrese nombre del estudiante")
    private String studentName;
    private String message;
    private Double averageScore;
    private List<SubjectDTO> subjects;
}
