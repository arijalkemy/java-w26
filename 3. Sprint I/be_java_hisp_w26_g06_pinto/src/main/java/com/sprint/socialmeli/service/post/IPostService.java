package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.*;

public interface IPostService {

    Integer createPost(PostDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);

    // Individual & Bonus
    Integer createPromoPost(PromoPostRequestDTO post);
    PromoCountResponseDTO getPromoCountBySellerId(Integer sellerId);
    PromoListResponseDTO getPromoPostListBySellerId(Integer sellerId);
}
