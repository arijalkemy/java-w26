package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class TokenResponseDto {
    private String token;
}
