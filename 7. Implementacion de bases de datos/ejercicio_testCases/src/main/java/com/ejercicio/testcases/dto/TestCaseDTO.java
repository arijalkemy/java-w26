package com.ejercicio.testcases.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {
    private long idCase;
    private String description;
    private boolean tested;
    private boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
