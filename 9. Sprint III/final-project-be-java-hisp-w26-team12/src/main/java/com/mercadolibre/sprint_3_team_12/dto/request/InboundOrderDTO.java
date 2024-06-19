package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint_3_team_12.dto.SectionDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class InboundOrderDTO {

    @NotNull @NotEmpty
    @Positive
    @JsonProperty("order_number")
    private Integer orderId;

    @NotNull @NotEmpty  @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("order_date")
    private Date orderDate;

    @NotNull
    @JsonProperty("section")
    private SectionDTO sectionDTO;

    @NotNull
    @JsonProperty("batch_stock")
    private List<BatchDTO> batchDTOList;
}


