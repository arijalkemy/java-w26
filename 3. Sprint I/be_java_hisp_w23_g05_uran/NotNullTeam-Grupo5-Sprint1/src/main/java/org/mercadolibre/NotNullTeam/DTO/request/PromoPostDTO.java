package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO {
    private Long user_id;
    private String date;
    private static Long currentId = 1L;
    private Long promo_id;
    ProductDTO product;
    private int category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;


    public PromoPostDTO(Long user_id, String date, ProductDTO product, int category, Double price, Boolean hasPromo, Double discount) {
        this.user_id = user_id;
        this.date = date;
        this.promo_id = currentId;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
        currentId++;
    }
}