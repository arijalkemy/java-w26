package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingOrderResponseDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("id_purchase_order")
    private Integer idPurchaseOrder;

    @JsonProperty("id_source_warehouse")
    private Integer idSourceWarehouse;

    @JsonProperty("id_destination")
    private Integer idDestination;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("date_last_updated")
    private String dateLastUpdated;

    @JsonProperty("state")
    private String state;


}
