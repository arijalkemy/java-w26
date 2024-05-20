package org.example.templatemvc.DTOs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestCaseResponse {

    private Long id;

    private String description;

    private Boolean tested;

    private Boolean passed;

    private int numberOfTries;

    private LocalDate lastUpdate;

}
