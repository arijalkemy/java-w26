package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.*;

public interface IPostService {

    void createPost(PostDTO post);

    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);

    void createPostWithPromo(PromoPostDTO post);

    PromoCountResponseDTO getPromosCountById(Integer seller_id);

    PromoListDTO getPromosListById(Integer seller_id);
}
