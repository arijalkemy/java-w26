package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockDTO {
     private Integer batch_number;
     private Integer current_quantity;
     private LocalDate due_date;
}
