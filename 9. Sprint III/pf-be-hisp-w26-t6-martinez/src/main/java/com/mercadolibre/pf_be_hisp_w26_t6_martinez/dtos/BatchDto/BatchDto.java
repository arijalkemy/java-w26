package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto implements Serializable {

    @NotNull(message = "El batch_number no debe ser null")
    @Positive
    @JsonProperty("batch_number")
    private Integer batchNumber;

    @NotNull(message = "El product_id no debe ser null")
    @Positive
    @JsonProperty("product_id")
    private Integer productId;

    @NotNull(message = "El current_temperature no debe ser null")
    @Positive
    @JsonProperty("current_temperature")
    private Double currentTemperature;

    @NotNull(message = "El minimum_temperature no debe ser null")
    @Positive
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;

    @NotNull(message = "El initial_quantity no debe ser null")
    @Positive
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;

    @NotNull(message = "El current_quantity no debe ser null")
    @Positive
    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @Pattern(regexp = "([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}",
            message = "El formato de manufacturing_date debe ser dd-mm-yyyy")
    @NotNull(message = "El manufacturing_date no debe estar vacio")
    @JsonProperty("manufacturing_date")
    private String manufacturingDate;

    @Pattern(regexp = "([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4} ([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]",
            message = "El formato de manufacturing_time debe ser dd-mm-yyyy hh:mm:ss")
    @NotNull(message = "El manufacturing_time no debe estar vacio")
    @JsonProperty("manufacturing_time")
    private String manufacturingTime;

    @Pattern(regexp = "([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4} ([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]",
            message = "El formato de due_date debe ser dd-mm-yyyy hh:mm:ss")
    @NotNull(message = "El due_date no debe estar vacio")
    @JsonProperty("due_date")
    private String dueDate;
}
