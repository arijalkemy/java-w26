package org.ejercicio.qatesters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;
}
