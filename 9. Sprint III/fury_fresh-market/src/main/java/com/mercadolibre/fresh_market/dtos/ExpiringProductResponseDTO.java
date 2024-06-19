package com.mercadolibre.fresh_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpiringProductResponseDTO {
    private List<ExpiringProductDTO> batchStock;

}
