package com.group03.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO implements Serializable {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    @JsonProperty("total_price")
    public double calculateTotalPrice() {
        if (hasPromo) {
            return price * (1 - discount);
        } else {
            return price;
        }
    }
}
