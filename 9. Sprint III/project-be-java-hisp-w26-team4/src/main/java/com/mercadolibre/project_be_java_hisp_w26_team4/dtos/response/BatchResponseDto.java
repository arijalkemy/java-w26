package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchResponseDto {
    @JsonAlias("id")
    @JsonProperty("batch_number")
    private Integer batchNumber;
    @JsonAlias("productId")
    @JsonProperty("product_id")
    private Integer productId;
    @JsonAlias("productTypeId")
    @JsonProperty("product_type_id")
    private Integer productTypeId;
    @JsonAlias("dueDate")
    @JsonProperty("due_date")
    private LocalDate dueDate;
    @JsonAlias("currentQuantity")
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
}