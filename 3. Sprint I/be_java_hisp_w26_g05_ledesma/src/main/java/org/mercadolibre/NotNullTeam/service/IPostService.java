package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostWithPromoDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsWithPromoDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PromosCountDTO;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);
    PromosCountDTO getCantPromosSellersByUserId(Long userId);
    Long createPostWithPromo(PostWithPromoDTO postWithPromoDTO);
    PostsWithPromoDTO getTopWeekPromosByUserId(Long userId);
    PostsWithPromoDTO getProductsOfMyFollowedByCategory(Long userId, int category, String order);
    void deleteSellerPostByPostId(Long sellerId, Long postId);
    PostsWithPromoDTO getSellerPostByProductName(Long buyerId, String productName, String order);
}
