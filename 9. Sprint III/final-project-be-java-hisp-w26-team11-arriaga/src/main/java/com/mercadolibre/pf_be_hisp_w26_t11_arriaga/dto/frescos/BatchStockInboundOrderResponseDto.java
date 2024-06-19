package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchStockInboundOrderResponseDto {
    private Integer batchNumber;
    private Integer currentQuantity;
    private Double currentTemperature;
    private Integer sectionCode;
    private String productName;
    private Double productPrice;
}
