package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class BatchDTO {
    @NotNull @NotEmpty @Positive
    @JsonProperty("batch_number")
    private Integer idBatch;
    @NotNull @NotEmpty @Positive
    @JsonProperty("product_id")
    private Integer idProduct;
    @NotNull @NotEmpty
    @JsonProperty("current_temperature")
    private Double currentTemperature;
    @NotNull @NotEmpty
    @JsonProperty("minimum_temperature")
    private Double minimunTemperature;
    @NotNull @NotEmpty @Positive
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;
    @NotNull @NotEmpty @PositiveOrZero
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
    @NotNull @NotEmpty @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;
    @NotNull @NotEmpty @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    @JsonProperty("manufacturing_time")
    private LocalDateTime manufacturingTime;
    @NotNull @NotEmpty  @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
