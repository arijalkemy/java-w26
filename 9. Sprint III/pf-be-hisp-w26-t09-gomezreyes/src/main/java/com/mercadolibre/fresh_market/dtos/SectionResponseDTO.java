package com.mercadolibre.fresh_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionResponseDTO {

    private Long sectionCode;
    private Long warehouseCode;

}
