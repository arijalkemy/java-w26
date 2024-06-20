package com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseOrderDTO {

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonProperty("buyer_id")
    private Integer buyerId;

    @JsonProperty("order_status")
    private StatusDTO orderStatus;

    private List<PurchasedProductDTO> products;
}
