package com.mercadolibre.project_be_java_hisp_w26_team5.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class BatchRequestDTO {
    @Size(max = 100)
    @NotNull(message = "Batch number cannot be null")
    @JsonProperty("batch_number")
    private String batchNumber;

    @NotNull(message = "Product id cannot be null")
    @JsonProperty("product_id")
    private Integer idProduct;

    @NotNull(message = "Current temperature cannot be null")
    @JsonProperty("current_temperature")
    private Double currentTemperature;

    @NotNull(message = "Minimum temperature cannot be null")
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;

    @Min(1)
    @NotNull(message = "Initial quantity cannot be null")
    @Min(value = 0, message = "Initial quantity cannot be less than 0")
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;

    @Min(1)
    @NotNull(message = "Current quantity cannot be null")
    @Min(value = 0, message = "Current quantity cannot be less than 0")
    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @NotNull(message = "Manufacturing date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;

    @NotNull(message = "Manufacturing time cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonProperty("manufacturing_time")
    private LocalDateTime manufacturingTime;

    @NotNull(message = "Due date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
