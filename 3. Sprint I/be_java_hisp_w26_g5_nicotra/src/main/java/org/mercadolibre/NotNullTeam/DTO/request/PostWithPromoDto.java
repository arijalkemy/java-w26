package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.PostResponseDTO;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostWithPromoDto extends PostResponseDTO {
    private Boolean has_promo;
    private Double discount;

    public PostWithPromoDto(PostResponseDTO postResponseDTO, Boolean has_promo, Double discount) {
        super(postResponseDTO.getUser_id(), postResponseDTO.getPost_id(), postResponseDTO.getDate(), postResponseDTO.getProduct(), postResponseDTO.getCategory(), postResponseDTO.getPrice());
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
