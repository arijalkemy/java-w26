package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockRequestDTO {

    @JsonProperty("batch_number")
    @NotNull(message = "Batch number is required")
    @Positive(message = "Batch number must be positive")
    private Long batchNumber;

    @JsonProperty("product_id")
    @NotNull(message = "Product ID is required")
    @Positive(message = "Product ID must be positive")
    private Long productId;

    @JsonProperty("current_temperature")
    @NotNull(message = "Current temperature is required")
    @Positive(message = "Current temperature must be positive")
    private Double currentTemperature;

    @JsonProperty("minimum_temperature")
    @NotNull(message = "Minimum temperature is required")
    @Positive(message = "Minimum temperature must be positive")
    private Double minimumTemperature;

    @JsonProperty("initial_quantity")
    @NotNull(message = "Initial quantity is required")
    @Positive(message = "Initial quantity must be positive")
    private Integer initialQuantity;

    @JsonProperty("current_quantity")
    @NotNull(message = "Current quantity is required")
    @Positive(message = "Current quantity must be positive")
    private Integer currentQuantity;

    @JsonProperty("manufacturing_date")
    @NotNull(message = "Manufacturing date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate manufacturingDate;

    @JsonProperty("manufacturing_time")
    @NotNull(message = "Manufacturing time is required")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime manufacturingTime;

    @JsonProperty("due_date")
    @NotNull(message = "Due date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;

}
