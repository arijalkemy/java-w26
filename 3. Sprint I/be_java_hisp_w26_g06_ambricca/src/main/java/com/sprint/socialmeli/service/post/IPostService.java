package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.*;

public interface IPostService {

    Integer createPost(PostDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);
    Integer createPromo(PromoDTO promoDTO);
    PromoPostCountResponseDTO getPromoPostCount(Integer sellerId);
    PromoPostListResponseDTO getPromoPostList(Integer sellerId);

}
