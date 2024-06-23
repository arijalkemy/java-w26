package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchInfoDueDateDTO {
    @JsonProperty("batch_number")
    private int batchNumber;
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_type_id")
    private int productTypeId;
    @JsonProperty("due_date")
    private LocalDate dueDate;
    @JsonProperty("current_quantity")
    private int currentQuantity;
}
