package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockResponseDTO {
    List<BatchStockDTO> batch_stock;
}
