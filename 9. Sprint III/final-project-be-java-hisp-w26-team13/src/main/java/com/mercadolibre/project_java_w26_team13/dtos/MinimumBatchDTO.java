package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MinimumBatchDTO {
    @JsonProperty("batch_number")
    private String batchNumber;

    @JsonProperty("current_quantity")
    private int currentQuantity;

    @JsonProperty("due_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dueDate;
}
