package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionDTO {
    private String message;
}

