package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.DTO.response.PromoProductsBySellerResponeseDTO;
import org.mercadolibre.NotNullTeam.model.PromoPost;
import org.mercadolibre.NotNullTeam.model.Seller;

public interface IPromoPostRepository {
    Long createPromoPost(PromoPost promoPost);

    PromoProductsBySellerResponeseDTO getPromoProductsBySeller(Seller seller);
}
