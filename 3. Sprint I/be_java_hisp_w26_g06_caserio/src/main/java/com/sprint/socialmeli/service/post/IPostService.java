package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.*;

import java.util.List;

public interface IPostService {

    void createPost(PostDTO post);

    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);

    void createPostWithPromo(PostPromoDTO post);

    PromoCountResponseDTO getPromosCountById(Integer seller_id);

    List<PromoListResponseDTO> getPromosListById(Integer seller_id);
}
