package org.example.pearl_jewelry.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrorDto {
    private Map<String, String> errorTree;
    private String uri;
}
