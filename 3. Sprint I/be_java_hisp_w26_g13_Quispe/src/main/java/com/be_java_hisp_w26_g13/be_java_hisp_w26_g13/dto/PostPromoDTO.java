package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO extends PostDTO{
    @JsonProperty("has_promo")
    private boolean hasPromo;
    @JsonProperty("discount")
    private double discount;
}
