package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class PurchaseOrderDTO {
    @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("date")
    private Date date;

    @NotNull @NotEmpty @Positive
    @JsonProperty("buyer_id")
    private Integer idBuyer;

    @NotNull
    @JsonProperty("order_status")
    private OrderStatusDTO orderStatus;

    @NotNull
    @JsonProperty("products")
    private List<ProductDTO> productDTO;

}
