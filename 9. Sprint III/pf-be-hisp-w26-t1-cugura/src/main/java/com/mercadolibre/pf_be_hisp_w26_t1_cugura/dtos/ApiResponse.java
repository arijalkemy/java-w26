package com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.OperationResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    OperationResponse operation;
    String message;
    Integer code;
}
