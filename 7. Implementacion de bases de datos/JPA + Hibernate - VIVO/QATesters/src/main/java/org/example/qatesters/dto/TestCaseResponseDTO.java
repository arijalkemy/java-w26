package org.example.qatesters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseResponseDTO {
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    LocalDate last_update = LocalDate.now();
}
