package org.example.g14.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostWithDiscountDto extends PostDto {

    private double discount;
    @JsonProperty("price_with_discount") private double priceWithDiscount;

    public PostWithDiscountDto(
        int user_id,
        int post_id,
        LocalDate date,
        ProductDto product,
        int category,
        double price,
        double discount,
        double priceWithDiscount
    ) {
        super(user_id, post_id, date, product, category, price);

        this.discount = discount;
        this.priceWithDiscount = priceWithDiscount;
    }
}
