package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BatchDTO {
    private Integer batchNumber;
    private Integer currentQuantity;
    private LocalDate dueTime;
}
