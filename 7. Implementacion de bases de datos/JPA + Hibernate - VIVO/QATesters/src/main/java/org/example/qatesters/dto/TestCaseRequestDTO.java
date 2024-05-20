package org.example.qatesters.dto;

import lombok.Data;

@Data
public class TestCaseRequestDTO {
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
}
