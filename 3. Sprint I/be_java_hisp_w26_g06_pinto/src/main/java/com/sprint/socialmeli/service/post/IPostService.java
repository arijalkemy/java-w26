package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.*;

import java.util.List;

public interface IPostService {

    Integer createPost(PostDTO post);
    void createPromoPost(PromoPostRequestDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);

    // INDIVIDUAL & BONUS
    PromoCountResponseDTO getPromoCountBySellerId(Integer sellerId);
    PromoListResponseDTO getPromoPostListBySellerId(Integer customer_id);
}
