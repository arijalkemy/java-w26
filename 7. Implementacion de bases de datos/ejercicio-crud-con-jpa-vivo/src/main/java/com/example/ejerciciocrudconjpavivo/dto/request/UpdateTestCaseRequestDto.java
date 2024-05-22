package com.example.ejerciciocrudconjpavivo.dto.request;

import lombok.Data;

@Data
public class UpdateTestCaseRequestDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
}
