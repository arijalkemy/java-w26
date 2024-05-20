package com.implbd.qatesters.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TestCaseRequestDTO {

    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @NotNull(message = "Tested no puede ser null")
    private Boolean tested;

    @NotNull(message = "Passed no puede ser null")
    private Boolean passed;

    @PositiveOrZero(message = "numberOfTries debe ser un cero o positivo")
    private Integer numberOfTries;

    @NotBlank(message = "La fecha no puede estar vacía")
    private String lastUpdate;

}
