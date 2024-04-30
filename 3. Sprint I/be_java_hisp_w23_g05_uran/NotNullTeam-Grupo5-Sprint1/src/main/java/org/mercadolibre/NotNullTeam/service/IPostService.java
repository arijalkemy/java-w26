package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PromoPostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.ProductsPromoCountDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PromoProductsBySellerResponeseDTO;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);


    Long createPromoPost(PromoPostDTO promoPostDTO);

    ProductsPromoCountDTO getProductsPromoCount(Long userId);

    PromoProductsBySellerResponeseDTO getListPromoProducts(Long userId);
}
