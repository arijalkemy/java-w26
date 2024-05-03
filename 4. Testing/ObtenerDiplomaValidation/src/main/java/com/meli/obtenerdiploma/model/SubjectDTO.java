package com.meli.obtenerdiploma.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    @Valid
    @NotNull(message = "Subject name is required")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre debe de comenzar con Mayuscula")
    @Size(message = "Subject name must be less than 30 characters", max = 30)
    String name;
    @NotNull(message="Score is required")
    @Max(value=10, message="Score can't be greater than 10")
    @Min(value=0, message="Score can't be less that cero")
    Double score;
}
