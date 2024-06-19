package com.mercadolibre.meli_frescos.dto.frescos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BatchStockExtendedDTO {
    private Integer batchNumber;
    private Integer productId;
    private Integer productTypeId;
    private LocalDate dueDate;
    private Integer currentQuantity;
}
