package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Max(value = 30, message = "El nombre no debe exceder los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*$",
            message = "El nombre debe empezar con mayúscula.",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    String name;
    @NotEmpty
    @Min(value = 0)
    @Max(value = 10)
    Double score;
}
