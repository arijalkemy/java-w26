package com.mercadolibre.project_java_w26_team13.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockDto {
    @JsonProperty("batch_number")
    private String batchNumber;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("current_temperature")
    private Double currentTemperature;
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
    @JsonProperty("manufacturing_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate manufacturingDate;
    @JsonProperty("manufacturing_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime manufacturingTime;
    @JsonProperty("due_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}
