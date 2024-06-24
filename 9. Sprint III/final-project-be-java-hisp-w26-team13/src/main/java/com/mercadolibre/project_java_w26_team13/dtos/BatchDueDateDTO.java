package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDueDateDTO {
    @JsonProperty("batch_number")
    private String batchNumber;
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("product_type_id")
    private Integer productTypeId;
    @JsonProperty("due_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dueDate;
}
