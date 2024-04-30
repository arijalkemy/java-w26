package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.*;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;
@Data
@NoArgsConstructor
public class PromoPostResponseDTO {
    private Long userId;
    private static Long currentId = 1L;
    private Long postId;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public PromoPostResponseDTO(Long userId, Long postId, String date, ProductDTO product, int category, Double price, Boolean hasPromo, Double discount) {
        this.userId = userId;
        this.postId = currentId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
        currentId++;
    }

    public PromoPostResponseDTO(Long userId, String date, ProductDTO product, int category, Double price, Boolean hasPromo, Double discount) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
