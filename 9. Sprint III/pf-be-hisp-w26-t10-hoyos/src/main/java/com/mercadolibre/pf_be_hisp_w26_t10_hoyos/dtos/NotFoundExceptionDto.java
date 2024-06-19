package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundExceptionDto {
    private String message;
}
