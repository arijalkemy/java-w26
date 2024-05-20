package com.meli.QA.Testers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private String lastUpdate;
}
