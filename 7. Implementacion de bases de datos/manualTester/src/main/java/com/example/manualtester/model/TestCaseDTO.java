package com.example.manualtester.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class TestCaseDTO {

    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;
}
