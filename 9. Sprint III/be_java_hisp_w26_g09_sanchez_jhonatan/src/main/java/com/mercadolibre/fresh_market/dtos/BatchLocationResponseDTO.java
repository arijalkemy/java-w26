package com.mercadolibre.fresh_market.dtos;

import com.mercadolibre.fresh_market.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchLocationResponseDTO {

    private SectionResponseDTO section;
    private Long productId;
    private List<BatchResponseDTO> batchStock;

}
