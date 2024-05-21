package com.w26.testcase.testcase.dto.Testcase;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateTestcase implements Serializable {
    
    @NotBlank
    @NotNull
    private String description;

    @NotNull
    private Boolean tested;

    @NotNull
    private Boolean passed;
    
    @NotNull
    private Integer number_of_tries;

    @NotNull
    private LocalDate last_update;

}
