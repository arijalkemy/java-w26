package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDataRequestDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "date cannot be null")
    private LocalDate date;

    @JsonProperty("buyer_id")
    @NotNull(message = "buyer_id cannot be null")
    private Integer buyerId;

    @JsonProperty("order_status")
    @NotNull(message = "order_status cannot be null")
    @Valid
    private OrderStatusRequestDTO orderStatus;

    @JsonProperty("products")
    @NotNull(message = "products cannot be null")
    @Valid
    private List<ProductRequestPurchaseOrderDTO> products;
}
