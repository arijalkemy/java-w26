package org.example.be_java_hisp_w26_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter @Setter
public class ValidationErrorsResponseDTO {
    private String message;
    private Map<String,String> errors;
}
