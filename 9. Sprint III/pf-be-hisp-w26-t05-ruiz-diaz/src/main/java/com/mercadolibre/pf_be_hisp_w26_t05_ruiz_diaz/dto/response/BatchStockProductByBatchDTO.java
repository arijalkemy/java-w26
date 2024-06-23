package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockProductByBatchDTO {
    @JsonProperty("batch_number")
    private int batchNumber;
    @JsonProperty("current_quantity")
    private int currentQuantity;
    @JsonProperty("due_date")
    private String dueDate;
}
