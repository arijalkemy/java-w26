package com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
