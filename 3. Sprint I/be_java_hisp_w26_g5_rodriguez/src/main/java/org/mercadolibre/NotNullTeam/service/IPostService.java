package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosCountResponse;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosResponse;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);

    Long newProductPromo(PostPromoRequestDto request);

    SellerPromosCountResponse getCountPromosBySellerId(Long userId);

    SellerPromosResponse getPromosBySellerId(Long userId);
}
