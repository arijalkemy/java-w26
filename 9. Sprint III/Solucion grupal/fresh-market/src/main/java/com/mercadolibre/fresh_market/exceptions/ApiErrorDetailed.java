package com.mercadolibre.fresh_market.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiErrorDetailed(String error, String message, Integer status, Object detail) implements Serializable {
}