package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PromoPostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;

public interface IPostService {
    void createPost(PostDTO postDTO);
    void createPost(PromoPostDTO promoPostDTO);
    PostsByFollowedDTO getPostsBySellerTwoWeeksAgo(Long userId, String order);
}
