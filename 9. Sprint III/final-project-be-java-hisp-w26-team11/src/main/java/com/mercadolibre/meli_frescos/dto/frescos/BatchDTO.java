package com.mercadolibre.meli_frescos.dto.frescos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BatchDTO {
    private Integer batchNumber;
    private Integer currentQuantity;
    private LocalDate dueTime;
}
