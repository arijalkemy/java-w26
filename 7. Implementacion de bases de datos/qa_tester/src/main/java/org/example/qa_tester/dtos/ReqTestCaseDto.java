package org.example.qa_tester.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqTestCaseDto {
    @NotBlank
    private String description;
    private Boolean tested;
    private Boolean passed;
    @NotNull
    @Positive
    @JsonProperty("number_of_tries")
    private int numberOfTries;
}
