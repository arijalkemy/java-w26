package org.example.integradorqatesters.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class TestCaseRequestDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;
}
