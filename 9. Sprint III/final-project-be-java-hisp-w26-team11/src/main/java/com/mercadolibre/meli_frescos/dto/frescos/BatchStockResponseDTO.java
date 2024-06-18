package com.mercadolibre.meli_frescos.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockResponseDTO {
    @JsonProperty("batch_number")
    private Integer batchNumber;
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("current_temperature")
    private Double currentTemperature;
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;
    @JsonProperty("manufacturing_time")
    private Time manufacturingTime;
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
