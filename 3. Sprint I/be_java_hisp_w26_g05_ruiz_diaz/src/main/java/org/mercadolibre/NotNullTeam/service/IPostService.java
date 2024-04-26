package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostWithPromoResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PromotionPostCountOfASellerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PromotionPostListOfASellerResponseDTO;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);

    PromotionPostCountOfASellerResponseDTO getPromotionPostCountOfASeller(Long userId);

    PostWithPromoResponseDTO createPostWithPromo(PostDTO postPromoRequestDTO);

    PromotionPostListOfASellerResponseDTO getPromotionPostListOfASeller(Long userId);
}
