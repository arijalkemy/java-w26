package com.mercadolibre.final_project_java_h_w26_t10.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderDto {

    @NotBlank(message = "order_number is required")
    @JsonProperty("order_number")
    Integer orderNumber;

    @NotBlank(message = "order_date is required")
    @JsonProperty("order_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate orderDate;

    @NotBlank(message = "section is required")
    @JsonProperty("section")
    SectionDto sectionDto;

    @NotBlank(message = "batch is required")
    @JsonProperty("batch_stock")
    List<BatchDto> batchDto;


}
