package org.example.compound_key_practice.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePurchaseDto {
    @JsonProperty("client_id")
    private Long clientId;
    private Date date;
    private Integer quantity;
    private Double total;
}
