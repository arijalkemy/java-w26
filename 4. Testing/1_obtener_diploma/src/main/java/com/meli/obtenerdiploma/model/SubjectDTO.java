package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @NotNull(message = "Subject Name should not be null.")
    String name;

    @Positive(message = "Score should be grater than zero.")
    Double score;
}
