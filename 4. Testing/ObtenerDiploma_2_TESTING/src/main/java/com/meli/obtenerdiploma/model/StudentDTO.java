package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    Long id;

    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;


    public StudentDTO(Builder builder){
        this.id = builder.id;
        this.studentName = builder.studentName;
        this.message = builder.message;
        this.averageScore = builder.averageScore;
        this.subjects = builder.subjects;
    }

    public static class Builder {
        Long id;
        String studentName;
        String message;
        Double averageScore;
        List<@Valid SubjectDTO> subjects;

        public StudentDTO.Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public StudentDTO.Builder studentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public StudentDTO.Builder message(String message) {
            this.message = message;
            return this;
        }

        public StudentDTO.Builder averageScore(Double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public StudentDTO.Builder subjects(List<SubjectDTO> subjects) {
            this.subjects = subjects;
            return this;
        }
        public StudentDTO build() {
            return new StudentDTO(this);
        }
    }
}
