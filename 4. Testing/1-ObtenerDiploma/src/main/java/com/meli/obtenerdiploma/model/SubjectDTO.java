package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter @Setter
@Validated
public class SubjectDTO {
    @NotNull
    String name;
    @Min(message = "The score must be at leats 1", value = 1)
    @Max(message = "The score max is 10", value = 10)
    Double score;
}
