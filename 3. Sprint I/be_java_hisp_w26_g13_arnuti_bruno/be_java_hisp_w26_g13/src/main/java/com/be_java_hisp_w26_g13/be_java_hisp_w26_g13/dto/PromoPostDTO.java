package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class PromoPostDTO extends PostDTO {
    @JsonProperty("has_promo")
    private boolean hasPromo;
    @JsonProperty("discount")
    private double discount;

    public PromoPostDTO(Integer postId, int userId, String date, ProductDTO product, int category, double price, boolean hasPromo, double discount) {
        super(postId, userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
