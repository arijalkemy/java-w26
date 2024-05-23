package org.example.qa_tester.dtos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrorDto {
    private Map<String, String> errorTree;
    private String uri;
}
