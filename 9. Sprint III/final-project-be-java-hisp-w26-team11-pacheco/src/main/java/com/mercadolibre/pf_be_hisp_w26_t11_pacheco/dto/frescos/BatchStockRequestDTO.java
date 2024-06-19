package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockRequestDTO {
    @JsonProperty("batch_number")
    @NotNull(message = "Batch number cannot be null")
    @Positive(message = "Batch number must be positive")
    private Integer batchNumber;
    @NotNull(message = "Product id cannot be null")
    @Positive(message = "Product id must be positive")
    @JsonProperty("product_id")
    private Integer productId;
    @NotNull(message = "Current temperature cannot be null")
    @Positive(message = "Current temperature must be positive")
    @JsonProperty("current_temperature")
    private Double currentTemperature;
    @NotNull(message = "Minimum temperature cannot be null")
    @Positive(message = "Minimum temperature must be positive")
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;
    @NotNull(message = "Initial quantity cannot be null")
    @Positive(message = "Initial quantity must be positive")
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;
    @NotNull(message = "Current quantity cannot be null")
    @Positive(message = "Current quantity must be positive")
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
    @NotNull(message = "Manufacturing date cannot be null")
    @JsonProperty("manufacturing_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufacturingDate;
    @NotNull(message = "Manufacturing time cannot be null")
    @JsonProperty("manufacturing_time")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingTime;
    @NotNull(message = "Due date cannot be null")
    @JsonProperty("due_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}
