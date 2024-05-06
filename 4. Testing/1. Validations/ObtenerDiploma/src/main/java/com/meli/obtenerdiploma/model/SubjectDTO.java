package com.meli.obtenerdiploma.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.MustBeInvokedByOverriders;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@Getter @Setter
public class SubjectDTO {
    @NotNull
    String name;

    @Min(value = 0, message = "Not a valid score")
    @Max(value = 10, message = "Not a valid score")
    Double score;
}
