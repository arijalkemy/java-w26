package org.mercadolibre.NotNullTeam.model;

import lombok.*;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PromoPostDTO;

import javax.net.ssl.SSLSession;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPost {
    private Long user_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public PromoPost(PromoPostDTO promoPostDTO) {
        this.user_id = promoPostDTO.getUser_id();
        this.date = promoPostDTO.getDate();
        this.category = promoPostDTO.getCategory();
        this.product = promoPostDTO.getProduct();
        this.price = promoPostDTO.getPrice();
        this.hasPromo = promoPostDTO.getHasPromo();
        this.discount = promoPostDTO.getDiscount();
    }




}
