package com.example.ejerciciocrudconjpavivo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateTestCaseRequestDto {
    private String description;
}
