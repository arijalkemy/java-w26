package org.example.qatester.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TestCaseDTORes {

    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUdate;
}
