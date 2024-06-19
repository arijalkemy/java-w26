package com.mercadolibre.sprint_3_team_12_malacara.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint_3_team_12_malacara.exceptions.ApiError;
import lombok.Data;

import java.util.List;

@Data
public class CartWithErrorsResponseDTO {
    @JsonProperty("total_price")
    private Double totalPrice;
    @JsonProperty("errors")
    private List<ApiError> errors;

    public CartWithErrorsResponseDTO(Double totalPrice){
        this.totalPrice = totalPrice;
    }

    public CartWithErrorsResponseDTO(List<ApiError> errors){
        this.errors = errors;
    }


}
