package com.mercadolibre.project_be_java_hisp_w26_team4.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class BatchDTO {
    @Min(value = 1)
    @JsonProperty("batch_number")
    private Long id;
    @Min(value = 1)
    @JsonProperty("product_id")
    private Long productId;
    @NotNull
    @JsonProperty("current_temperature")
    private Double currentTemperature;
    @NotNull
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;
    @NotNull
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;
    @JsonProperty("current_quantity")
    @NotNull
    private Integer currentQuantity;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonProperty("manufacturing_time")
    private LocalDateTime manufacturingTime;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
