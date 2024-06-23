package org.example.ejercicioqatester.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCaseToUpdateDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;
}
