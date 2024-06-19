package com.mercadolibre.sprint3_individual_perez.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
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
    private Date manufacturingDate;
    @NotNull @NotEmpty @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    @JsonProperty("manufacturing_time")
    private Date manufacturingTime;
    @NotNull @NotEmpty  @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("due_date")
    private Date dueDate;
}
