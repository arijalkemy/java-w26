package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions;

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
