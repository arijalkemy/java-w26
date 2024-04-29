package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class SubjectDTO {
    String name;
    @Min(value = 0, message = "Score must be greater than or equal to 0")
    @Max(value = 10, message = "Score must be less than or equal to 10")
    Double score;
}
