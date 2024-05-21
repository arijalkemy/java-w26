package com.w26.testcase.testcase.dto.Testcase;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostTestcase implements Serializable {

    @NotBlank
    private String description;
    private Boolean tested = false;
    private Boolean passed = false;
    private Integer number_of_tries = 0;
    private LocalDate last_update = LocalDate.now();
}
