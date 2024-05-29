package com.w26.seguros_autos.seguros_autos.mediator.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SuccesfullyResponse implements Serializable {
    String message;
    Object result;
}
