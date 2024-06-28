package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthException {
    private Integer status;
    private String message;
}
