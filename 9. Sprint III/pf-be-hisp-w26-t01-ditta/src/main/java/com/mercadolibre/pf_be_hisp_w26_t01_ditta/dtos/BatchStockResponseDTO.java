package com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchStockResponseDTO {
    List<BatchStockDTO> batch_stock;
}
