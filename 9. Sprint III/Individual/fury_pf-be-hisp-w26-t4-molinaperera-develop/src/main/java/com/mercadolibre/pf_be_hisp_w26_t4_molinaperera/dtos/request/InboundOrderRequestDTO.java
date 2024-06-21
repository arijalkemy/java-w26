package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.BatchDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.SectionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class InboundOrderRequestDTO {
    @JsonProperty("order_number")
    @Min(value = 1)
    private Long id;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("order_date")
    private LocalDate orderDate;
    @NotNull
    @Valid
    private SectionDTO section;
    @NotNull
    @Valid
    @JsonProperty("batch_stock")
    private List<BatchDTO> batchList;
}
