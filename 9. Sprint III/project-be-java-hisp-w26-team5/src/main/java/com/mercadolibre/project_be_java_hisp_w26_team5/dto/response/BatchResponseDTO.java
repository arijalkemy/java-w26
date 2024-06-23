package com.mercadolibre.project_be_java_hisp_w26_team5.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchResponseDTO {
    @JsonProperty("batch_number")
    private String batchNumber;
    @JsonProperty("product_id")
    private Integer idProduct;
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
    private LocalDateTime manufacturingTime;
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
