package org.example.qttesters.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestTestCaseDto {
    @NotNull(message = "Description field is required")
    private String description;
    @NotNull(message = "Tested field is required")
    private Boolean tested;
    @NotNull(message = "Passed field is required")
    private Boolean passed;
    @NotNull(message = "Last_updated field is required")
    private LocalDate last_updated;
}
