package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "Ingrese nombre de estudiante")
    @Pattern(regexp = "(?=[A-Z])[\\p{L}0-9\\p{Punct} ]*", message = "Ingresar un nombre que empiece con mayúscula")
    @Length(max = 50, message = "El nombre debe tener a lo sumo 50 caracteres")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "Debe haber al menos una materia registrada")
    List<@Valid SubjectDTO> subjects;
}
