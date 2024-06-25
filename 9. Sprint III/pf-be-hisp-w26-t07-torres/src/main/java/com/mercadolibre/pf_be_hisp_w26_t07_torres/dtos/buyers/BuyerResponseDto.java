package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.buyers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class BuyerResponseDto {
    private Long id;
    private String nit;
    private String name;
    private String lastName;
}
