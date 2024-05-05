package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    @NotNull(message = "The subject name cannot be null")
    @Size(max = 30, message = "The subject name size cannot be higher than 30 characters")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The subject name have to start with Uppercase")
    @NotEmpty (message = "The subject name cannot be empty")
    String name;
    @NotNull (message = "The subject score cannot be null")
    @PositiveOrZero (message = "The subject Score cannot be negative")
    @Max(value = 10, message = "The subject Score cannot be higher than 10")
    Double score;
}
