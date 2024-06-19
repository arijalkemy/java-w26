package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchResponseDTO {

    private Integer batchNumber;
    private Integer currentQuantity;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}
