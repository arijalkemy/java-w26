package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Response(String message, Object result) {   
}
