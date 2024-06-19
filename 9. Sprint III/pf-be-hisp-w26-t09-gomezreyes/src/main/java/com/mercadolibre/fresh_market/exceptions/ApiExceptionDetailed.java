package com.mercadolibre.fresh_market.exceptions;

import lombok.Getter;

@Getter
public class ApiExceptionDetailed extends ApiException {
    
    private Object detail;
    
    public ApiExceptionDetailed(String code, String description, Integer statusCode, Object detail) {
        super(code, description, statusCode);
        this.detail = detail;
    }
}
