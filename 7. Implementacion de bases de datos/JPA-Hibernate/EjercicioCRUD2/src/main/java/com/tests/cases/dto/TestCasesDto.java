package com.tests.cases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCasesDto {
    private String description;
    private boolean tested;
    private boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;
}
