package com.ejercicio.testcases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PostRequestDTO {
    private String description;
    private boolean tested;
    private boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
