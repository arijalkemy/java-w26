package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosCountResponse;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosResponse;

public interface IPostService {
    void createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsBySellerTwoWeeksAgo(Long userId, String order);
    void newProductPromo(PostPromoRequestDto request);

    SellerPromosCountResponse getCountPromosBySellerId(Long userId);

    SellerPromosResponse getPromosBySellerId(Long userId);
}
