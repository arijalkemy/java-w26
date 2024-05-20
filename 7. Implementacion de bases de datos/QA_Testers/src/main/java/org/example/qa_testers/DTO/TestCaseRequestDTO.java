package org.example.qa_testers.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class TestCaseRequestDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
}
