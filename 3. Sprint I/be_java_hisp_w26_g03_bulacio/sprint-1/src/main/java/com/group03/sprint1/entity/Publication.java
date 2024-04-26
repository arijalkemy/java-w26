package com.group03.sprint1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Publication {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public Double calculateTotalPrice() {
        if (hasPromo) {
            return price * (1 - discount);
        } else {
            return price;
        }
    }
}
