package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchInfoDto {
    @JsonProperty("batch_number")
    Long id;

    @JsonProperty("current_quantity")
    Integer currentQuantity;

    @JsonProperty("due_date")
    LocalDate dueDate;
}
