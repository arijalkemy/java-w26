package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    //No nulo ni con espacios vacios
    @NotBlank
    //Nombre con tamaño minimo de 2 y máximo de 50
    @Size(min = 2, max = 50)
    String studentName;

    //No nulo ni con espacios vacios
    @NotBlank
    //mensaje con tamaño minimo de 3 y máximo de 20
    @Size(min = 3, max = 20)
    String message;

    //Score minimo de 0
    @Min(0)
    Double averageScore;

    //Lista no vacia
    @NotEmpty
    //Valida en cascada los subjects
    @Valid
    List<SubjectDTO> subjects;
}
