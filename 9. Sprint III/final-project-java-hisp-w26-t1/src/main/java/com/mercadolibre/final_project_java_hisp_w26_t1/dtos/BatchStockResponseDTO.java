package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchStockResponseDTO {
    List<BatchStockDTO> batch_stock;
}
