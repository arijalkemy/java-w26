package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.mercadolibre.fresh_market.model.InboundOrder;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.Section;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchDTO {
    @JsonProperty("batch_number")
    private Integer batchNumber;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("current_temperature")
    private Double currentTemperature;
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;
    @JsonProperty("initial_Quantity")
    private Integer initialQuantity;
    @JsonProperty("current_Quantity")
    private Integer currentQuantity;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty("manufacturing_time")
    private LocalDateTime manufacturingTime;
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
