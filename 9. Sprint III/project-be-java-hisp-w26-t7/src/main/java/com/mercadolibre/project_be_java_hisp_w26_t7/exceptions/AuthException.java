package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthException extends RuntimeException {
    private Integer status;
    private String message;

    public AuthException(String message) {
        super(message);
        this.status = 403;
    }
}
