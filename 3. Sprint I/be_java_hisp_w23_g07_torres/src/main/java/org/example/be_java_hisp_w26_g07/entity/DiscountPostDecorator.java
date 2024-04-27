package org.example.be_java_hisp_w26_g07.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountPostDecorator extends PostDecorator {
    @JsonProperty("has_promo")
    private Boolean has_promo;
    @JsonProperty("discount")
    private Double discount;
}
