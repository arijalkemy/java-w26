package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto {

    @NotBlank(message = "batch_number is required")
    @JsonProperty("batch_number")
    private Integer batchNumber;

    @NotBlank(message = "product_id is required")
    private Integer product_id;

    @NotBlank(message = "current_temperature is required")
    @JsonProperty("current_temperature")
    private Double currentTemperature;

    @NotBlank(message = "minimum_temperature is required")
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;

    @NotBlank(message = "initial_quantity is required")
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;

    @NotBlank(message = "current_quantity is required")
    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @NotBlank(message = "manufacturing_date is required")
    @JsonProperty("manufacturing_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate manufacturingDate;

    @NotBlank(message = "manufacturing_time is required")
    @JsonProperty("manufacturing_time")
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime manufacturingTime;

    @NotBlank(message = "due_date is required")
    @JsonProperty("due_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;
}
